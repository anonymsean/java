package com.sean.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.sean.message.Message;
import com.thoughtworks.xstream.XStream;

public class MessageUtil {

	public static Map<String,String> xmlToMap(HttpServletRequest request) throws DocumentException, IOException{
		Map<String,String> map=new HashMap<String,String>();
		
		SAXReader reader=new SAXReader();
		
		Document document=reader.read(request.getInputStream());
		
		List<Element> list=document.getRootElement().elements();
		
		for(Element element:list){
			map.put(element.getName(), element.getText());
		}
		return map;
	}
	public static String textMessageToXml(Message text) throws UnsupportedEncodingException{
		
		XStream s=new XStream();
		
		s.alias("xml", text.getClass());
		
		return s.toXML(text);
		
	}
}
