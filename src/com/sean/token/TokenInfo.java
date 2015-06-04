package com.sean.token;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TokenInfo {
	/*
	 * http请求方式: GET
	https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx542c3ba4752dd089&secret=df6988804f13cb2ee0e6308272e04244
	 */
		private static String APP_SCRECT="df6988804f13cb2ee0e6308272e04244";
		private static String APP_ID="wx542c3ba4752dd089";

		public TokenInfo(){
			
		}
		
		public String getToken(){
			
			String requestURL="https://api.weixin.qq.com/cgi-bin/token?"
					+ "grant_type=client_credential&appid="+APP_ID+"&secret="+APP_SCRECT;	
			String token="";
			try {
				URL url=new URL(requestURL);
				HttpURLConnection conn=(HttpURLConnection) url.openConnection();
				BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
				do{
					token+=br.readLine();
				}while(br.readLine()=="");
				conn.disconnect();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(token);
			return token;
		}
}
