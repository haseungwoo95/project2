package com.koreait.hboard;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchl = request.getParameter("searchl");
		int chksearch = MyUtils.getParamInt("chksearch", request);
		System.out.println(chksearch);
		if(chksearch == 1) {
			List<BoardVO> list = BoardDOA.searchList(searchl);
			request.setAttribute("list", list);
		} else {
			List<BoardVO> list = BoardDOA.selList();
			request.setAttribute("list", list);
		}
		
		MyUtils.openJSP("list", request, response);
	}

}
