package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.modelUser;

import DAO.LoginDAO;


@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String user = request.getParameter("username");
//		String pass = request.getParameter("password");
//		
//		if(user.equals("test123") && pass.equals("test123")) 
//		{
//			HttpSession session = request.getSession();
//			session.setAttribute("username", user);
//			response.sendRedirect("admin.jsp");
//			
//		}
//		else
//		{
//			response.sendRedirect("err.jsp");
//		}
//	}

		try {
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			LoginDAO loginDAO = new LoginDAO();
			modelUser a = loginDAO.checkLogin(user, pass);
			if(a==null) {
				response.sendRedirect("err.jsp");
			}else {
				response.sendRedirect("admin.jsp");
			}
		} catch (Exception e) {
			}
		
		}
	
}
