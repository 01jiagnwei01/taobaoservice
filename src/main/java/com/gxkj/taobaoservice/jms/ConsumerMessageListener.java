package com.gxkj.taobaoservice.jms;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.ConnectionHolder;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.transaction.support.TransactionSynchronizationUtils;

import com.gxkj.taobaoservice.daos.impl.LogInfosDaoImpl;
import com.gxkj.taobaoservice.entitys.LogInfos;
import com.gxkj.taobaoservice.enums.LogType;
import com.gxkj.taobaoservice.jms.dto.SerializableEntity;
@Component
public class ConsumerMessageListener implements MessageListener  {
	
	@Autowired
	private LogInfosDaoImpl logInfosDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private int count = 0;  
	
	public void onMessage(Message message) {
		
//		Session session = sessionFactory.getCurrentSession();
//		 Transaction tx= session.beginTransaction();
		//AbstractPlatformTransactionManager.getTransaction();
		//HibernateTransactionManager.doGetTransaction();
		//这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换  
		SessionHolder  sessionHolder = (SessionHolder )TransactionSynchronizationManager.getResource(sessionFactory);
		 Transaction transAction = sessionHolder.getTransaction();
 
		 try {
			 Integer deliveryCount = 	message.getIntProperty("JMSXDeliveryCount");
			 System.out.println("加载次数deliveryCount为"+deliveryCount);
		} catch (JMSException e1) {
			e1.printStackTrace();
		}
		 
		       if (message instanceof TextMessage) { 
		    	   TextMessage textMsg = (TextMessage) message;  
			       System.out.println("接收到一个纯文本消息。");  
			       try {  
			            System.out.println("消息内容是：" + textMsg.getText());  
			        } catch (JMSException e) {  
			            e.printStackTrace();  
			       } 
		       }else  if (message instanceof ObjectMessage) { 
		    	   ObjectMessage objMessage = (ObjectMessage) message;
		    	   try {
					Object obj = objMessage.getObject();
					 SerializableEntity entity = (SerializableEntity) obj;  
					 
					 System.out.println("接收到一个ObjectMessage，包含对象为："+entity+",对象内容是："+entity.getMsg());
				} catch (JMSException e) {
					 
					e.printStackTrace();
				}  
		       }
		       LogInfos log = new LogInfos();
		       log.setCreateTime(new Date());
		       log.setLogType(LogType.FIND_PASSWORD);
		       log.setUserId(1);
		       System.out.println("=====================count="+count);
		       try {
				logInfosDao.insert(log);
				System.out.println("logid ="+log.getId());
				count ++;  
				System.out.println("count="+count);
				  if(count <= 10){	
					  throw new RuntimeException("Error! 出错啦！");  
				  }
			    	   
//			    	   
//				  transAction.commit();

				} catch ( Exception e) {
					/**
					 * 需要同步配置文件里 sessionTransacted为false;否则
					 * 回滚会重复执行7次
					 * 
					 */
					transAction.rollback();
					 
						//logInfosDao.delete(log);
						
					System.out.println(1);
					 
					//e.printStackTrace();
				}
		      

	}

}
