package com.sean.message;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.sean.util.MessageUtil;

public class Message {
	private String ToUserName="";
	private String FromUserName="";
	private String CreateTime="";
	private String MsgType="";
	private String Content="";
	private String MsgId="";
	
	public static final String TEXT="text";
	public static final String IMAGE="image";
	public static final String VOICE="voice";
	public static final String VIDEO="video";
	public static final String SHORTVIDEO="shortvideo";
	public static final String LOCATION="location";
	public static final String LINK="link";
	public static final String EVENT="event";
	public static final String SUBSCRIBE="subscribe";
	public static final String UNSUBSCRIBE="unsubscribe";
	public static final String SCAN="scan";
	public static final String CLICK="click";
	public static final String VIEW="view";
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	public static Message initMessage(String fromUserName,String toUserName,String content,String msgType){
		Message text=new Message();
		text.setToUserName(fromUserName);
		text.setFromUserName(toUserName);
		text.setCreateTime(new Date().getTime()+"");
		text.setContent("您发送的内容是："+content+"-->"+msgType+"类型");
		text.setMsgType("text");
		return text;
	}
	
	public void doWork(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer=response.getWriter();
		Map<String,String> map=new HashMap<String,String>();
		
		String message="";
		try {
			map=MessageUtil.xmlToMap(request);
			String toUserName=map.get("ToUserName");
			String fromUserName=map.get("FromUserName");
			String createTime=map.get("CreateTime");
			String msgType=map.get("MsgType");
			String content=map.get("Content");
			String msgId=map.get("MsgId");
							
			if(msgType.equals(Message.TEXT)){
				Message text=Message.initMessage(fromUserName, toUserName, content,Message.TEXT);
				message=MessageUtil.textMessageToXml(text);				
				//System.out.println("输出内容为："+message);
				writer.print(message);
				
			}else if(msgType.equals(Message.CLICK)){
				Message text=Message.initMessage(fromUserName, toUserName, content,Message.CLICK);
				message=MessageUtil.textMessageToXml(text);				
				//System.out.println("输出内容为："+message);
				writer.print(message);
			}else if(msgType.equals(Message.EVENT)){
				Message text=Message.initMessage(fromUserName, toUserName, content,Message.EVENT);
				message=MessageUtil.textMessageToXml(text);				
				//System.out.println("输出内容为："+message);
				writer.print(message);
			}else if(msgType.equals(Message.IMAGE)){
				Message text=Message.initMessage(fromUserName, toUserName, content,Message.IMAGE);
				message=MessageUtil.textMessageToXml(text);				
				//System.out.println("输出内容为："+message);
				writer.print(message);
			}else if(msgType.equals(Message.LINK)){
				Message text=Message.initMessage(fromUserName, toUserName, content,Message.LINK);
				message=MessageUtil.textMessageToXml(text);				
				//System.out.println("输出内容为："+message);
				writer.print(message);
			}else if(msgType.equals(Message.LOCATION)){
				Message text=Message.initMessage(fromUserName, toUserName, content,Message.LOCATION);
				message=MessageUtil.textMessageToXml(text);				
				//System.out.println("输出内容为："+message);
				writer.print(message);
			}else if(msgType.equals(Message.SCAN)){
				Message text=Message.initMessage(fromUserName, toUserName, content,Message.SCAN);
				message=MessageUtil.textMessageToXml(text);				
				//System.out.println("输出内容为："+message);
				writer.print(message);
			}else if(msgType.equals(Message.SHORTVIDEO)){
				Message text=Message.initMessage(fromUserName, toUserName, content,Message.SHORTVIDEO);
				message=MessageUtil.textMessageToXml(text);				
				//System.out.println("输出内容为："+message);
				writer.print(message);
			}else if(msgType.equals(Message.SUBSCRIBE)){
				Message text=Message.initMessage(fromUserName, toUserName, content,Message.SUBSCRIBE);
				message=MessageUtil.textMessageToXml(text);				
				//System.out.println("输出内容为："+message);
				writer.print(message);
			}else if(msgType.equals(Message.UNSUBSCRIBE)){
				Message text=Message.initMessage(fromUserName, toUserName, content,Message.UNSUBSCRIBE);
				message=MessageUtil.textMessageToXml(text);				
				//System.out.println("输出内容为："+message);
				writer.print(message);
			}else if(msgType.equals(Message.VIDEO)){
				Message text=Message.initMessage(fromUserName, toUserName, content,Message.VIDEO);
				message=MessageUtil.textMessageToXml(text);				
				//System.out.println("输出内容为："+message);
				writer.print(message);
			}else if(msgType.equals(Message.VIEW)){
				Message text=Message.initMessage(fromUserName, toUserName, content,Message.VIEW);
				message=MessageUtil.textMessageToXml(text);				
				//System.out.println("输出内容为："+message);
				writer.print(message);
			}else if(msgType.equals(Message.VOICE)){
				Message text=Message.initMessage(fromUserName, toUserName, content,Message.VOICE);
				message=MessageUtil.textMessageToXml(text);				
				System.out.println("输出内容为："+message);
				writer.print(message);
			}
			
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			writer.close();
		}
		
	}
}
