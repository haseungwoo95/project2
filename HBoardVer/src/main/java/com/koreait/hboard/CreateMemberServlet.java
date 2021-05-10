package com.koreait.hboard;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/createm")
public class CreateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/WEB-INF/jsp/createm.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Id = request.getParameter("Id");
		String Pw = request.getParameter("Pw");
		String Pwchk = request.getParameter("Pwchk");
		String Nm = request.getParameter("Nm");
		String idchko = request.getParameter("idchko");
		boolean idchkok = Boolean.parseBoolean(idchko);

		if (Id == "" || Pw == "" || Pwchk == "" || Nm == "") {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('항목을 채워주세요'); location.href='" + "/createm?id=" + Id + "&pw=" + Pw + "&pwchk=" + Pwchk + "&nm=" + Nm + "';</script>");
			out.close();
		} else if (idchkok == false) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('아이디 중복확인을 해주세요'); location.href='" + "/createm?id=" + Id + "&pw=" + Pw + "&pwchk=" + Pwchk + "&nm=" + Nm + "';</script>");
			out.close();
		} else if (Pw.equals(Pwchk) == false) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호 불일치'); location.href='" + "/createm?id=" + Id + "&pw=" + Pw + "&nm=" + Nm + "';</script>");
			out.close();
		} else {
			LoginLO lo = new LoginLO();
			lo.setId(Id);
			lo.setPw(Pw);
			lo.setNm(Nm);

			LoginDAO.cmem(lo);

			response.sendRedirect("/login");
		}
	}
}
