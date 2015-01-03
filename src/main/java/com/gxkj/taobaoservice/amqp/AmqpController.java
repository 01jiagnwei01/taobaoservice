package com.gxkj.taobaoservice.amqp;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxkj.taobaoservice.controllers.demo.dto.AmqOrder;
@Controller
@RequestMapping("/demo/amq")
public class AmqpController {

//	@Autowired
//	@Qualifier("amqpClientTemplate")
	private AmqpTemplate template;
	
//	@Autowired
//	@Qualifier("stockController")
//	private StockController stockController ;
	
//	@Autowired
//	@Qualifier("stockServiceGateway")
//	private StockServiceGateway stockServiceGateway;
//	
//	@Autowired
//	@Qualifier("quoteController")
//	private QuoteController quoteController;

	@Autowired
	@Qualifier("amqpTemplateWeiBo")
	private AmqpTemplate amqpWeiBoTemplate;
	
	@Autowired
	@Qualifier("amqpTemplatePinglun")
	private AmqpTemplate amqpTemplatePingLun; 
 
	
	@RequestMapping(value="",method={RequestMethod.GET})
	public String index(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,String msg){
		return "demo/amq";
	}
	
	/**
	 * template send方法
	 * void send(Message message) throws AmqpException;
	 * void send(String routingKey, Message message) throws AmqpException;
	 * void send(String exchange, String routingKey, Message message) throws AmqpException;
	 * 
	 * 
	 * void convertAndSend(Object message) throws AmqpException;
	 * void convertAndSend(String routingKey, Object message) throws AmqpException;
	 * void convertAndSend(String exchange, String routingKey, Object message) throws AmqpException;
	 * void convertAndSend(Object message, MessagePostProcessor messagePostProcessor) throws AmqpException;
	 * void convertAndSend(String routingKey, Object message,   MessagePostProcessor messagePostProcessor) throws AmqpException;
	 * void convertAndSend(String exchange, String routingKey, Object message,   MessagePostProcessor messagePostProcessor) throws AmqpException;
	 * 
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param msg
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/sendweibo",method={RequestMethod.POST})
	public String sendMsg(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,String msg){
		// template.convertAndSend("myqueue",StringUtils.isEmpty(msg)?"":msg);
		//template.send("marketData.topic", "quotes.nasdaq.FOO", new Message((StringUtils.isEmpty(msg)?"":msg).getBytes(), null));
		
//		String messageId = new Date().getTime()+"";
//		//可设置属性值参考http://docs.spring.io/spring-amqp/docs/latest-ga/api/org/springframework/amqp/core/MessageProperties.html
//		AmqOrder pojo = new AmqOrder();
//		pojo.setMsg(StringUtils.isEmpty(msg)?"":msg);
//		MessageProperties props = MessagePropertiesBuilder.newInstance()
//				.setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
//				.setMessageId(messageId)
//				.setHeader("bar", "baz")
//				.build();
//			Message message = MessageBuilder.withBody(pojo.toString() .getBytes())
//				.andProperties(props)
//				.build();
//			
//		 template.send("marketData.topic", "quotes.nasdaq.FOO", message);
		 
		
		
//		AmqOrder order = new AmqOrder();
//		order.setMsg(StringUtils.isEmpty(msg)?"":msg);
//		 template.convertAndSend("queue_one_key",order);
		 //template.convertAndSend("remoting.exchange", "remoting.queue",order);
		 //Tracer
		 String reply = "send ok";//(String) replyTemplate.convertSendAndReceive(StringUtils.isEmpty(msg)?"":msg);
		 
		 
		 try {
//			 	Date d = new Date();
//			 	String s = d.getTime()/100000000+" "+(StringUtils.isEmpty(msg)?"":msg);
//				stockController.sendTradeRequest(s);
			 
			 
			 
			
			 AmqOrder order = new AmqOrder();
			 order.setMsg(StringUtils.isEmpty(msg)?"":msg);
			 String defaultReplyTo = "weiboQueue";
			 
//			 amqpWeiBoTemplate.convertAndSend(order);
			 
			 amqpWeiBoTemplate.convertSendAndReceive(order, new MessagePostProcessor() {
					public Message postProcessMessage(Message message) throws AmqpException {
						message.getMessageProperties().setReplyTo(defaultReplyTo);
						try {
							message.getMessageProperties().setCorrelationId(UUID.randomUUID().toString().getBytes("UTF-8"));
						}
						catch (UnsupportedEncodingException e) {
							throw new AmqpException(e);
						}
						return message;
					}
				});
			 
//			 amqpWeiBoTemplate.convertAndSend(order, new MessagePostProcessor() {
//					public Message postProcessMessage(Message message) throws AmqpException {
//						message.getMessageProperties().setReplyTo(defaultReplyTo);
//						try {
//							message.getMessageProperties().setCorrelationId(UUID.randomUUID().toString().getBytes("UTF-8"));
//						}
//						catch (UnsupportedEncodingException e) {
//							throw new AmqpException(e);
//						}
//						return message;
//					}
//				});
				 
			}
			catch (Exception ex) {
				ex.printStackTrace();
				reply = "failure" ;
			}
		return reply;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/sendPinglun",method={RequestMethod.POST})
	public String sendMsgPingLun(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,String msg){
		 
		 String reply = "send ok"; 
		 
		 try {
			 amqpTemplatePingLun.convertAndSend(StringUtils.isEmpty(msg)?"":msg);
		 }
			catch (Exception ex) {
				ex.printStackTrace();
				reply = "failure" ;
			}
		return reply;
	}
	/**
	 * Object receiveAndConvert() throws AmqpException;
	 * Object receiveAndConvert(String queueName) throws AmqpException;
	 *  template.receiveAndConvert("myqueue");
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/receiv",method={RequestMethod.POST})
	public String receiveMsg(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap ){
		//return (String) template.receiveAndConvert("myqueue");
		 
//		boolean received =
//		        this.template.receiveAndReply("quotes.nasdaq.FOO", new ReceiveAndReplyCallback<AmqOrder, AmqInvoice>() {
//		                public AmqInvoice handle(AmqOrder order) {
//		                	/**
//		                	 * 伪代码：执行处理过程
//		                	 * processOrder(order);
//		                	 */
//		                        return  new AmqInvoice();
//		                }
//		        });
//		if (received) {
//		        //log.info("We received an order!");
//			System.out.println("查到结果了");
//		}
		AmqOrder order = (AmqOrder) template.receiveAndConvert("queue_one_key");
		return order.getMsg();
	}
	 
}
