package com.koreait.board6;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board6.user.UserVO;

public class MyUtils {
	public static int getLoginUserPk(HttpServletRequest req) {
		if(req == null) {return 0;}
		UserVO vo = getLoginUser(req);
		return vo.getIuser();
	}
	public static UserVO getLoginUser(HttpServletRequest req) {
		if(req == null) {return null;}
		HttpSession hs = req.getSession();
		return (UserVO)hs.getAttribute("loginUser");
	}
	
	public static int getParamInt(String key, HttpServletRequest req) {
		String val = req.getParameter(key);
		int intVal = parseStringToInt(val);
		return intVal;
	}
	
	public static int parseStringToInt(String val) {
		try {
			return Integer.parseInt(val);
		} catch(Exception e) {
			return 0;
		}
	}
	
	public static void openJSP(String title, String page, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute(Const.TITLE, title);
		req.setAttribute(Const.PAGE, page);
		
		String jsp = "/WEB-INF/view/template.jsp";
		req.getRequestDispatcher(jsp).forward(req, res);
	}
}
