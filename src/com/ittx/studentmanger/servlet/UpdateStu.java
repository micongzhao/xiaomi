package com.ittx.studentmanger.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ittx.studentmanger.model.*;
import com.ittx.studentmanger.util.StudentDB;

public class UpdateStu extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); //解决post请求乱码
		resp.setContentType("text/html;charset=utf-8");//设置响应编码
		
		String number=req.getParameter("id");
		String userName=req.getParameter("userName");//获取学生信息
		System.out.println(number);
		String age=req.getParameter("age");
		String sex=req.getParameter("sex");
		String img=req.getParameter("img");
		
		int num=Integer.parseInt(number);
		int ages=Integer.parseInt(age);
		boolean sexs=sex.equals("1")?true:false;
		Student student=new Student(userName,num,ages,sexs,img);
		StudentDB.getInstance().updateStudent(student);
		resp.sendRedirect(req.getContextPath()+"/Student.jsp");
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doGet(req, resp);
			}

}
