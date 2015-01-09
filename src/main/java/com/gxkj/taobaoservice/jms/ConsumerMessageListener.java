package com.gxkj.taobaoservice.jms;

import java.sql.SQLException;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gxkj.taobaoservice.daos.impl.LogInfosDaoImpl;
import com.gxkj.taobaoservice.entitys.LogInfos;
import com.gxkj.taobaoservice.enums.LogType;
import com.gxkj.taobaoservice.jms.dto.SerializableEntity;
@Component
public class ConsumerMessageListener implements MessageListener  {
	
	@Autowired
	private LogInfosDaoImpl logInfosDao;
	
	private int count = 0;  
	
	public void onMessage(Message message) {
	 
		//这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换  
		        
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
		       System.out.println("count="+count);
		       try {
				logInfosDao.insert(log);
				System.out.println("logid ="+log.getId());
			} catch (SQLException e) {
				 
				e.printStackTrace();
			}
		       if(count == 0){
		    	   count ++;  
		    	   throw new RuntimeException("Error! 出错啦！");  

		       }

	}

}
