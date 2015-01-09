package com.gxkj.taobaoservice.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxkj.taobaoservice.jms.dto.SerializableEntity;

/**
 * @author Administrator
 * 生产者测试
 *
 */

@Controller
@RequestMapping("/demo/jms")
public class ProducerController {
	
	@Autowired
	@Qualifier("jmsTemplate")
	private JmsTemplate jmsTemplate; 
	
	@Autowired  
	@Qualifier("queueDestination")  
	private Destination destination;

	
	@RequestMapping(value="",method={RequestMethod.GET})
	public String index(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,String msg){
		return "demo/jms";
	}
	
	@ResponseBody
	@RequestMapping(value="/sendweibo",method={RequestMethod.POST})
	public String sendMsg(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,String msg){
		 
		 String reply = "send ok";//(String) replyTemplate.convertSendAndReceive(StringUtils.isEmpty(msg)?"":msg);
		 
		 try {
			 System.out.println("---------------生产者发送消息-----------------");  
	         System.out.println("---------------生产者发了一个消息：" + msg); 
/***
 * 发送普通文本
 */
//	         jmsTemplate.send(destination, new MessageCreator() {  
//	             public Message createMessage(Session session) throws JMSException {  
//	                 return session.createTextMessage(msg);  
//	             }  
//	         });
/**
 * 发生对象数据
 */
	         SerializableEntity entity = new SerializableEntity();
	         entity.setMsg(msg);
	         jmsTemplate.convertAndSend(destination, entity);
	         
			}catch (Exception ex) {
				ex.printStackTrace();
				reply = "failure" ;
			}
		return reply;
	}

}
