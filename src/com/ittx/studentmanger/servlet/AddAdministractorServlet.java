package com.ittx.studentmanger.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ittx.studentmanger.model.Administractor;
import com.ittx.studentmanger.util.AdministractorDB;
import com.ittx.studentmanger.util.StudentDB;


public class AddAdministractorServlet extends HttpServlet {

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //解决post请求乱码
		response.setContentType("text/html;charset=utf-8");//设置响应编码
		System.out.println("111");
		String name = request.getParameter("name");
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		
	

			response.sendRedirect("./Administractor.jsp?flag=false");
	
			System.out.println("222");
			Administractor administractor = new Administractor(name,userName,passWord);
			AdministractorDB.getInstance().addAdministractorDB(administractor);; //添加用户到数据库

			response.sendRedirect("./Administractor.jsp");
			System.out.println("5555");
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

