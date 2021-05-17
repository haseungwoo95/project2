package com.koreait.board5.board;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;
import com.koreait.board5.cmt.CmtDAO;
import com.koreait.board5.cmt.CmtVO;
import com.koreait.board5.user.UserVO;

@WebServlet("/board/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO vo2 = MyUtils.getLoginUser(request);
		if(vo2 == null) {
			response.sendRedirect("/user/userLogin");
			return;
		}
		int iboard = MyUtils.getParamInt("iboard", request);
		BoardVO vo = BoardDAO.selBoard(iboard);
		
		request.setAttribute("vo", vo);
		
		CmtVO cmt = new CmtVO();
		cmt.setIboard(iboard);
		
		List<CmtVO> list = CmtDAO.selCmtList(cmt);
		request.setAttribute("cmtList", list);
		
		MyUtils.openJSP("board/detail", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
