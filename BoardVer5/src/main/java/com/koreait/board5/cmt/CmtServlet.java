package com.koreait.board5.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

@WebServlet("/board/cmt")
public class CmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int icmt = MyUtils.getParamInt("icmt", request);
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPk(request);
		
		CmtVO vo = new CmtVO();
		vo.setIcmt(icmt);
		vo.setIuser(iuser);
		
		CmtDAO.delCmt(vo);
		
		response.sendRedirect("detail?iboard=" + iboard);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmt = request.getParameter("cmt");
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPk(request);
		
		CmtVO vo = new CmtVO();
		vo.setCmt(cmt);
		vo.setIboard(iboard);
		vo.setIuser(iuser);
		
		CmtDAO.insCmt(vo);
		
		response.sendRedirect("detail?iboard=" + iboard);
	}
}
