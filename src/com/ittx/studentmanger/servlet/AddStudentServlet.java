package com.ittx.studentmanger.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ittx.studentmanger.model.Student;
import com.ittx.studentmanger.util.ConnectDB;
import com.ittx.studentmanger.util.StudentDB;

//@WebServlet({ "/AddStudentServlet", "/AddStudentServlet.do" })
public class AddStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //解决post请求乱码
		response.setContentType("text/html;charset=utf-8");//设置响应编码
		
		String userName = request.getParameter("userName");
		String number = request.getParameter("number");
		String age = request.getParameter("age");
		String img = request.getParameter("img");
	
		
		int numbers = Integer.parseInt(number);
		int ages =Integer.parseInt(age);
		if(StudentDB.getInstance().isExistStudentByNumber(numbers)){
			response.sendRedirect("./AddStu.jsp?fla g=false");
		}else{
			Student student = new Student(userName,numbers,ages,true,img);
			StudentDB.getInstance().addStudent(student); //添加学生到数据库

			response.sendRedirect("./Student.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
