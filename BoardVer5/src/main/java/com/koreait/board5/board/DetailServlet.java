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
		UserVO uvo = MyUtils.getLoginUser(request);
		if(uvo == null) {
			response.sendRedirect("/user/userLogin");
			return;
		}
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPk(request);
		BoardVO vo = BoardDAO.selBoard(iboard);
		
		request.setAttribute("vo", vo);
		
		CmtVO cvo = new CmtVO();
		cvo.setIboard(iboard);
		
		List<CmtVO> list = CmtDAO.selCmtList(cvo);
		request.setAttribute("cmtList", list);
		
		int a = BoardDAO.cntLike(iboard);
		request.setAttribute("cnt", a);
		
		vo.setIuser(iuser);
		int i = BoardDAO.chkLike(vo);
		request.setAttribute("chk", i);
		MyUtils.openJSP("board/detail", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
