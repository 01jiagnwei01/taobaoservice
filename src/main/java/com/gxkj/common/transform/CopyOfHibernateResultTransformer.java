package com.gxkj.common.transform;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.transform.ResultTransformer;

import com.gxkj.taobaoservice.entitys.AdminUser;

 

public class CopyOfHibernateResultTransformer  implements ResultTransformer {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 2001776736450169294L;
	private final Class<?> resultClass;
 
	
	public   CopyOfHibernateResultTransformer(Class<?> resultClass) { 
		if ( resultClass == null ) {
			throw new IllegalArgumentException( "resultClass cannot be null" );
		}
		this.resultClass = resultClass;
	}
	
	/**
	 * @param  Object[] tuple 值列表。原始SQL查询后的返回值数组
	 * @param  String[] aliases 列别名列表。原始SQL查询结果返回的列名（这个需要注意，Oracle等DB可能不区分大小写，
	 * 所以在通过列名反射取得对象类的Set方法前，如果需要按驼峰式的命名法，需要自己制定别名规则）。
	 */
	public Object transformTuple(Object[] tuple, String[] aliases) {
		/**
		 * 获取类属性与数据库列的映射关系
		 */
		Map<String, PropertyBean> map;
		Object record = null;
		String propertyName = null;
		Object propertyValue = null;
		try {
			record = this.resultClass.newInstance();
			map = this.getColumn2PropertyMap(this.resultClass);
			for ( int i = 0; i < aliases.length; i++ ) {
				String alias = aliases[ i ];
				if ( alias != null ) {
					PropertyBean propertyBean = map.get(alias.toUpperCase());
					if(propertyBean != null &&  tuple[i] != null){
						propertyName = propertyBean.getPropertyName();
						if("status".equals(propertyName)){
							System.out.println(tuple[i].getClass().getName());
						}
						String className = propertyBean.getPropertyClass().getName();
						if("int".equals(className) || "java.lang.Integer".equals(className)){
							propertyValue =   new Integer( tuple[i].toString());
						}else if("double".equals(className) || "java.lang.Double".equals(className)){
							propertyValue =   new Double( tuple[i].toString());
						}else if("long".equals(className) || "java.lang.Long".equals(className)){
							propertyValue =   new Long( tuple[i].toString());
						}else  if("float".equals(className) || "java.lang.Float".equals(className)){
							propertyValue =   new Float( tuple[i].toString());
						}else  if("byte".equals(className) || "java.lang.Byte".equals(className)){
							propertyValue =   new Float( tuple[i].toString());
						}else  if("short".equals(className) || "java.lang.Short".equals(className)){
							propertyValue =   new Float( tuple[i].toString());
						}else{
							//其余的可补充
							propertyValue =   tuple[i];
						}
						
						PropertyUtils.setProperty(record, propertyName, propertyValue);
						 
					}
				}
			}
			 
		} catch (InstantiationException     | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			 
			e.printStackTrace();
		} 
		return record;
	}

	/**
	 * @param
	 */
	@SuppressWarnings("rawtypes")
	public List transformList(List collection) {
		 return collection;  
	}
	 
	
	private Map<String,PropertyBean> getColumn2PropertyMap(Class<?> clazz) {
		Field field = null;
		String propertyName = null;
		String columnName = null;
		int modifier = 0;
		Annotation annotation = null;
		Map<String,PropertyBean> column2Property = new HashMap<String,PropertyBean>();
		while (clazz != null && !clazz.getName().equals(Object.class.getName())) {
			PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(clazz);
			for (PropertyDescriptor p : properties) {
				//获得此特性的编程名称
				propertyName = p.getName();
				try {
					if("class".equals(propertyName))continue;
					field = clazz.getDeclaredField(propertyName);
				} catch (NoSuchFieldException | SecurityException e) {
			
					e.printStackTrace();
				}
				if (field != null) {
					modifier = field.getModifiers();
					if ((modifier & Modifier.FINAL) > 0
							|| (modifier & Modifier.NATIVE) > 0
							|| (modifier & Modifier.STATIC) > 0
							|| (modifier & Modifier.TRANSIENT) > 0
							|| (modifier & Modifier.VOLATILE) > 0) {
						continue;
					}
					if(field.isAnnotationPresent(Column.class )){
						annotation = field.getAnnotation(Column.class);
						columnName = ((Column) annotation).name();
						if (columnName == null || columnName.length() == 0) {
							columnName = field.getName();
						}
					}else{
						columnName = field.getName();
					}
					
					if (!column2Property.containsKey(propertyName)) {
						PropertyBean propertyBean =  new  PropertyBean();
						propertyBean.setField(field);
						propertyBean.setPropertyWriteMethod( p.getWriteMethod());
						propertyBean.setPropertyReadMethod(p.getReadMethod());
						propertyBean.setPropertyClass(field.getType());
						propertyBean.setPropertyName(propertyName);
						
						column2Property.put(columnName.toUpperCase(), propertyBean);
					}
					
				}
			}
			clazz = clazz.getSuperclass();
		}
		 
		return column2Property;
	}
 
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println( (int)'1');
	}

}
