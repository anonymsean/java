package com.sean.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sean.message.Message;
import com.sean.token.TokenInfo;
import com.sean.util.CheckUtil;

/**
 * Servlet implementation class CoreServlet
 */
@WebServlet("/CoreServlet")
public class CoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String signature=request.getParameter("signature");
		String timestamp=request.getParameter("timestamp");
		String nonce=request.getParameter("nonce");
		String echostr=request.getParameter("echostr");
		System.out.println("WeiXin Validating...");
		PrintWriter out=response.getWriter();
		if(CheckUtil.checkSignature(signature, timestamp, nonce)){
			out.write(echostr);
		}
		out.close();
		out=null;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");		
		
		Message m=new Message();
		m.doWork(request,response);
		
		TokenInfo ti=new TokenInfo();
		ti.getToken();
		
	}

}
