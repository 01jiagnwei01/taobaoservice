package com.gxkj.common.util;

import java.security.*;
import javax.crypto.*;
import sun.misc.*;

/**
 * 加密解密算法
 *
 */
public class Encrypt {
	private Key key;
	private byte[] byteMi = null;
	private byte[] byteMing = null;
	private String strMi = "";
	private String strM = "";

	// 根据参数生成KEY
	public void setKey(String strKey) {
		try {
			KeyGenerator _generator = KeyGenerator.getInstance("DES");
			_generator.init(new SecureRandom(strKey.getBytes()));
			this.key = _generator.generateKey();
			_generator = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 加密String明文输入,String密文输出
	public void setEncString(String strMing) {
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			this.byteMing = strMing.getBytes("UTF8");
			this.byteMi = this.getEncCode(this.byteMing);
			this.strMi = base64en.encode(this.byteMi);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			this.byteMing = null;
			this.byteMi = null;
		}
	}

	// 加密以byte[]明文输入,byte[]密文输出
	private byte[] getEncCode(byte[] byteS) {
		byte[] byteFina = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byteFina = cipher.doFinal(byteS);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}

		return byteFina;
	}

	// 解密:以String密文输入,String明文输出
	public void setDesString(String strMi) {
		BASE64Decoder base64De = new BASE64Decoder();
		try {
			this.byteMi = base64De.decodeBuffer(strMi);
			this.byteMing = this.getDesCode(byteMi);
			this.strM = new String(byteMing, "UTF8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			base64De = null;
			byteMing = null;
			byteMi = null;
		}

	}

	// 解密以byte[]密文输入,以byte[]明文输出
	private byte[] getDesCode(byte[] byteD) {
		Cipher cipher;
		byte[] byteFina = null;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byteFina = cipher.doFinal(byteD);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	// 返回加密后的密文strMi
	public String getStrMi() {
		return strMi;
	}

	// 返回解密后的明文
	public String getStrM() {
		return strM;
	}
	public static void main(String[] args) {
		String key = "abc";
		Encrypt encrypt = new Encrypt();
		
		encrypt.setKey(key);    //调用set函数设置密钥。
		encrypt.setEncString("endtime=2014-12-02 23:59:59&id=1&email=01jiangwei01@163.com");//将要加密的明文传送给Encrypt.java进行加密计算。
	   String miwen=encrypt.getStrMi();  //调用get函数获取加密后密文。
	   System.out.println(miwen);
	   
	   encrypt.setDesString(miwen);   //将要解密的密文传送给Encrypt.java进行解密计算。
	   String mingWen=encrypt.getStrM(); //调用get函数获取解密后明文。
	   System.out.println(mingWen);


	}

}
