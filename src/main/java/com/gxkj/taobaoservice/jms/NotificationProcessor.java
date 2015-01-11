package com.gxkj.taobaoservice.jms;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.support.JmsUtils;
import org.springframework.transaction.annotation.Transactional;

import com.gxkj.taobaoservice.entitys.Notification;
import com.gxkj.taobaoservice.services.NotificationService;

public class NotificationProcessor implements MessageListener {
	private static Logger logger = LoggerFactory.getLogger(NotificationProcessor.class);
	
	private NotificationService notificationService;
	 

	@Override
	public void onMessage(Message message) {
		try {
			int driveCount = this.getDeliveryNumber(message);
			System.out.println("驱动次数为："+driveCount);
			Notification notification = (Notification) ((ObjectMessage) message).getObject();
			logger.info("Received notification | Id: "+notification.getId()+" | Redelivery: "+getDeliveryNumber(message));

			checkPreprocessException(notification);
			saveToBD(notification);
			checkPostprocessException(message, notification);
		} catch (JMSException e) {
			throw JmsUtils.convertJmsAccessException(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Execution failure after receiving the message and before saving it to the DB
	 * 
	 * @param notification
	 */
	private void checkPreprocessException(Notification notification) {
		if (notification.getId() == 1) {
			throw new RuntimeException("error after receiving message");
		}
	}
	
	/**
	 * Execution failure after saving the message to the DB
	 * 
	 * @param message
	 * @param notification
	 * @throws JMSException
	 */
	private void checkPostprocessException(Message message, Notification notification) throws JMSException {
		if (notification.getId() == 2 && getDeliveryNumber(message) < 2) {
			throw new RuntimeException("error after processing message");
		}
	}
	
	/**
	 * Returns how many times the message has been delivered
	 * 
	 * @param message
	 * @return
	 * @throws JMSException
	 */
	private int getDeliveryNumber(Message message) throws JMSException {
		 
		Enumeration  e = message.getPropertyNames();
		while(e.hasMoreElements()){
			String name = (String) e.nextElement();
			System.out.println(name);
		}
		int model = message.getJMSDeliveryMode();
		System.out.println("model="+model);
		return message.getIntProperty("JMSXDeliveryCount");
	}
	
	private void saveToBD(Notification notification) throws SQLException {
		//String query = "insert into NOTIFICATIONS(id, message) values (?,?)";
		//jdbcTemplate.update(query, notification.getId(), notification.getMessage());
		notificationService.saveNotification(notification);
	}

	public NotificationService getNotificationService() {
		return notificationService;
	}

	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	

	 
	
	

}
