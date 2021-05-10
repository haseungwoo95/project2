package com.koreait.hboard;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int intIboard = MyUtils.getParamInt("iboard", request);
		
		
		BoardDOA.bcount(intIboard);
		
		BoardVO vo = BoardDOA.selitem(intIboard);
		request.setAttribute("data", vo);
		
		List<BoardVO> clist = BoardDOA.selListComm(intIboard);
		request.setAttribute("clist", clist);
	
		MyUtils.openJSP("detail", request, response);
				
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comm = request.getParameter("comm");
		String iboard = request.getParameter("iboard");
		int intIboard = Integer.parseInt(iboard);
		
		BoardVO vo = new BoardVO();
		vo.setComm(comm);
		vo.setIboard(intIboard);
		
		BoardDOA.insertComm(vo);
		
		response.sendRedirect("/detail?iboard=" + iboard);
	}

}
