package com.koreait.board5.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board5.MyUtils;
import com.koreait.board5.user.UserVO;

@WebServlet("/board/list")
public class ListBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		if (loginUser == null) {
			response.sendRedirect("/user/userLogin");
			return;
		}
		String title = request.getParameter("search");
		int chksearch = MyUtils.getParamInt("chksearch", request);
		
		if (chksearch == 1) {
			List<BoardVO> list = BoardDAO.searchBoard(title);
			request.setAttribute("list", list);
		} else {
			List<BoardVO> list = BoardDAO.selBoardList();
			request.setAttribute("list", list);
		}
		
		MyUtils.openJSP("board/list", request, response);
	}
}
