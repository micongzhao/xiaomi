package com.ittx.studentmanger.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ittx.studentmanger.daoimpl.AddAdministractorDaompl;
import com.ittx.studentmanger.model.Administractor;
import com.ittx.studentmanger.sever.Userserver;


@WebServlet({ "/UserListServlets", "/userlist" })
public class UserListServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddAdministractorDaompl userServer = new AddAdministractorDaompl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Administractor> userLists = userServer.getAllUser();
		request.setAttribute("userLists", userLists);
		request.getRequestDispatcher("Administractor.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
