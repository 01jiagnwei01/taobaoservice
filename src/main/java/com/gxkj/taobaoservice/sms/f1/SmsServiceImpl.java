package com.gxkj.taobaoservice.sms.f1;
/**
 * 参考
 * https://jersey.java.net/documentation/latest/client.html
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.gxkj.common.exceptions.BusinessException;
import com.gxkj.taobaoservice.dto.SmsResponse;
import com.gxkj.taobaoservice.sms.SmsService;
@Service("F1SmsServiceImpl")
public class SmsServiceImpl implements SmsService {

	private static final Log log = 
			LogFactory.getLog(SmsServiceImpl.class);
	
	private static final String sendSmsUrl = "http://sms.1xinxi.cn/asmx/smsservice.aspx";
 
	/**
	 * 0	提交成功
	 * 1	含有敏感词汇
	 * 2	余额不足
	 * 3	没有号码
	 * 4	包含sql语句
	 * 10	账号不存在
	 * 11	账号注销
	 * 12	账号停用
	 * 13	IP鉴权失败
	 * 14	格式错误
	 * -1	系统异常
	 * 909 我方网络问题
	 */
	public SmsResponse sendSms(String content, String mobiles, Date sendTime)
			throws BusinessException {
		 
//		Form form = new Form();
//		form.param("name", "15001279241");
//		form.param("pwd", "6DEFC4996C7652F442D9160F8F08");
//		form.param("content", content);
//		form.param("mobile", mobiles);
//		if(sendTime != null){
//			form.param("stime", sendTime.toString());
//		}
//		form.param("type", "pt");
		String result = null;
		String name = "15001279241"; 
		String sign="谷谷道场";
		
		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer(sendSmsUrl+"?");

		// 向StringBuffer追加用户名
		sb.append("name="+name);

		// 向StringBuffer追加密码（登陆网页版，在管理中心--基本资料--接口密码，是28位的）
		sb.append("&pwd=6DEFC4996C7652F442D9160F8F08");

		// 向StringBuffer追加手机号码
		sb.append("&mobile="+mobiles);

		// 向StringBuffer追加消息内容转URL标准码
		try {
			sb.append("&content="+URLEncoder.encode(content,"UTF-8"));
		
		//追加发送时间，可为空，为空为及时发送
		sb.append("&stime=");
		
		//加签名
		sb.append("&sign="+URLEncoder.encode(sign,"UTF-8"));
		
		//type为固定值pt  extno为扩展码，必须为数字 可为空
		sb.append("&type=pt&extno=");
		// 创建url对象
		//String temp = new String(sb.toString().getBytes("GBK"),"UTF-8");
	 
		log.info("sb:"+sb.toString());
		URL url = new URL(sb.toString());

		// 打开url连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// 设置url请求方式 ‘get’ 或者 ‘post’
		connection.setRequestMethod("POST");

		// 发送
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

		// 返回发送结果
		String inputline = in.readLine();
		
		// 返回结果为‘0，20140009090990,1，提交成功’ 发送成功   具体见说明文档
		  result = URLDecoder.decode(inputline,"UTF-8");
		  log.info("result:"+result);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
		SmsResponse smsResponse = new SmsResponse();
		smsResponse.setResult(false);
		if(result == null){
			smsResponse.setMsg("网络不通");
			smsResponse.setCode("909");
			return smsResponse;
		}
		
		
		String[] results = result.split(",");
		switch(results[0]){
			case "0":
				smsResponse.setResult(true);
				smsResponse.setSendId(results[1]);
				smsResponse.setInvalidNum(Integer.parseInt(results[2]));
				smsResponse.setSuccessNum(Integer.parseInt(results[3]));
				smsResponse.setInBlackNum(Integer.parseInt(results[4]));
				smsResponse.setMsg(results[5]);
				break;
			default:
				smsResponse.setMsg(results[1]);
				break; 	
		}
		return smsResponse;
	}

}
