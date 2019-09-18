package com.anzhi.solidwaste.common.utils;

import com.anzhi.solidwaste.common.domain.StringConstant;
import com.anzhi.solidwaste.common.fdfs.FastDFSClientWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 
 * 一些工具类
 * @author anzhi
 */
@Component
public class CodeUtil {



	public static final String INSPECT = "1";
	public static final String MAINTENANCE = "2";
	public static final String MOBILE = "3";



	@Autowired
	public static FastDFSClientWrapper fastDFSClientWrapper;


	public static void main(String[] args) {
		System.out.println(decodeUnicode("\\u6c99\\u4e95\\u4e8c\\u671f\\u5165\\u6c34\\u53e3\\u6c34\\u8d28\\u76d1\\u6d4b\\u7ad9"));
	}
	
	/**
	 * 生成事件编号
	 * 按日期生成前八位 后四位随机生成
	 */
	public static String createEventId(){		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");	
		StringBuffer str = new StringBuffer(df.format(new Date()));	
		
		for(int i=0;i<4;i++){
            char ch=str.charAt(new Random().nextInt(str.length()));
            str.append(ch);
        }
		return str.toString();	
	}

	/**
	 * 生成任务编号
	 */
	public static String createTaskId(String type) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		StringBuffer str = new StringBuffer(df.format(new Date()));
		switch (type) {
			case "inspect" :
				str.insert(0, StringConstant.TASK + INSPECT);
				break;
			case "maintenance" :
				str.insert(0, StringConstant.TASK + MAINTENANCE);
				break;
			case "mobile" :
				str.insert(0, StringConstant.TASK + MOBILE);
				break;
		}
		return str.toString();
	}


	/**
	 * 生成路径编号
	 */
	public static String createRoadStr(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer str = new StringBuffer(df.format(new Date()));
		return str.toString();
	}


	/**
	 * 生成图片编号
	 * @return
	 */
	
	public static String createImageId(){	
		return UUID.randomUUID().toString().replaceAll("-","");	
	}
	
	/**
	 * 生成图片路径数组
	 * @param
	 * @return
	 */
	public static List<String> createImgUrls(String urls){		
		List<String> imgs = new ArrayList<String>();		
		String[] s = urls.split("\\/");
		for(int i=0;i<s.length;i++){
			imgs.add(s[i]);
		}	
		return imgs;
	}

	/**
	 * 获取当前时间
	 * @return
	 * @throws ParseException
	 */
	public static Date getCurrentTime() throws ParseException {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		return sdf.parse(sdf.format(now));
	}
	
	/**
	 * 校验手机号码
	 * @param phone
	 * @return
	 */
	public static boolean checkPhone(String phone) {
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		if(phone.length() != 11) {
			return false;
		}else {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(phone);
			return matcher.matches();
		}
	}


	public static String dealURL(String url){
		String port1 = "8886/";
		String port2 = "8887/";
		String port3 = "8889/";

		StringBuffer sb = new StringBuffer(url);
		String[] res = url.split("/");

		System.out.println("--------------  切掉/  ：" + res[0]);


		switch ( res[0] ){
			case "group1" :
				sb.insert(0, port1);
				break;
			case "group3" :
				sb.insert(0, port2);
				break;
			case "group2" :
				sb.insert(0, port3);
				break;
		}
		return sb.toString();
	}


	private static final char[] CHARS = new char[]{
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			'~', '@', '#', '$', '%', '^', '&', '*'
	};


	public static String randomGenerate(int length) {
		List<String> list = new ArrayList<String>(CHARS.length);
		for (int i = 0; i < CHARS.length; i++) {
			list.add(String.valueOf(CHARS[i]));
		}
		Collections.shuffle(list);

		int count = 0;
		StringBuffer sb = new StringBuffer();
		Random random = new Random(System.nanoTime());
		while (count < length) {
			int i = random.nextInt(list.size());
			sb.append(list.get(i));
			count++;
		}
		return sb.toString();
	}

	/*
	 * 中文转unicode编码
	 */
	public static String gbEncoding(final String gbString) {
		char[] utfBytes = gbString.toCharArray();
		String unicodeBytes = "";
		for (int i = 0; i < utfBytes.length; i++) {
			String hexB = Integer.toHexString(utfBytes[i]);
			if (hexB.length() <= 2) {
				hexB = "00" + hexB;
			}
			unicodeBytes = unicodeBytes + "\\u" + hexB;
		}
		return unicodeBytes;
	}
	/*
	 * unicode编码转中文
	 */
	public static String decodeUnicode(final String dataStr) {
		int start = 0;
		int end = 0;
		final StringBuffer buffer = new StringBuffer();
		while (start > -1) {
			end = dataStr.indexOf("\\u", start + 2);
			String charStr = "";
			if (end == -1) {
				charStr = dataStr.substring(start + 2, dataStr.length());
			} else {
				charStr = dataStr.substring(start + 2, end);
			}
			char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
			buffer.append(new Character(letter).toString());
			start = end;
		}
		return buffer.toString();
	}

}
