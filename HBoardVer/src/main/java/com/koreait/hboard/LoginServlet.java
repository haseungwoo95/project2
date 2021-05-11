package com.koreait.hboard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/WEB-INF/jsp/login.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Id = request.getParameter("Id");
		String Pw = request.getParameter("Pw");
		
		LoginLO lo = new LoginLO();
		lo.setId(Id);
		lo.setPw(Pw);
		
		LoginLO log = LoginDAO.login(lo);
		
		if(log == null) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('아이디 또는 비밀번호를 확인하세요'); location.href='"+ "/login"  +"';</script>");
			out.close();			
					
		} else {
			HttpSession hs = request.getSession();
			hs.setAttribute("loginSuccess", true);
			response.sendRedirect("/list");
		}
	}
}
