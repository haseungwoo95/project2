package com.koreait.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;


@WebServlet("/board/like")
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPk(request);
		
		BoardVO vo = new BoardVO();
		vo.setIboard(iboard);
		vo.setIuser(iuser);
		int i = BoardDAO.searchLike(vo);
		if(i == 1) {
			BoardDAO.delBoardLike(vo);
		} else {
			BoardDAO.boardLike(vo);
		}
		response.sendRedirect("detail?iboard="+iboard);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
