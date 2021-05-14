package com.koreait.board5.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board5.MyUtils;

@WebServlet("/user/userLogin")
public class userLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO vo = MyUtils.getLoginUser(request);
		if(vo != null) {
			response.sendRedirect("/board/list");
			return;
		}
		MyUtils.openJSP("user/userLogin", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");

		UserVO vo = new UserVO();
		vo.setUid(uid);

		UserVO userL = UserDAO.selUser(vo);
//		if(BCrypt.checkpw(upw, userL.getUpw())) {
//			userL.setUpw(null);
//			HttpSession hs = request.getSession();
//			hs.setAttribute("loginUser", userL);
//			
//			response.sendRedirect("/board/list");
//		}
		if (userL == null) {// 아이디 없음
			request.setAttribute("errMsg", "아이디를 확인해 주세요.");
		} else if (BCrypt.checkpw(upw, userL.getUpw())) {
			// 아이디 있음 & 비밀번호 체크
			userL.setUpw(null);
			HttpSession hs = request.getSession();
			hs.setAttribute("loginUser", userL);
			
			response.sendRedirect("/board/list");
			return;
		} else {//비번 틀림
			request.setAttribute("errMsg", "비밀번호를 확인해 주세요.");
		}
		doGet(request, response);
	}
}
