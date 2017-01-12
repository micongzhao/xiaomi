package com.ittx.studentmanger.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet({ "/Myserver", "/login.do" })
public class Myserver extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");////
		resp.setContentType("text/html;charset=UTF-8");//

		System.out.println("Get hello servlet!");

		String userName = req.getParameter("userName");
		String passWord = req.getParameter("passWord");
		String autoLogin = req.getParameter("autoLogin");


		System.out.println("LoginServlet userName :" + userName
				+ " \n passWord :" + passWord);

		PrintWriter pw = resp.getWriter();

		if (userName.equals("xiaomi") && passWord.equals("123")){
			
			if("true".equals(autoLogin)){				
				saveCookie(resp, userName, passWord,60*60*1);	
			}else{
				saveCookie(resp, userName, passWord, 0);
				System.out.println("qws");
			}
		
			
			HttpSession session=req.getSession();
			session.setAttribute("user", userName);	
		
			resp.sendRedirect("index.jsp");
		} else {
			resp.sendRedirect("login.jsp?isSucuess=false");
		}
	 
		pw.close();

	}
	public void saveCookie(HttpServletResponse response,String userName,String passWord,int maxAGE){
		Cookie cookie_use = new Cookie("name", userName);
		Cookie cookie_psw = new Cookie("psw", passWord);
		cookie_use.setMaxAge(maxAGE);
		cookie_psw.setMaxAge(maxAGE);
		response.addCookie(cookie_use);
		response.addCookie(cookie_psw);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("LoginServlet doPost >>>>");
		doGet(req, resp);
	}
}
