package com.koreait.hboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
	public static void openJSP(String fileNm, HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String fileNmm = "/WEB-INF/jsp/" + fileNm + ".jsp";
		request.getRequestDispatcher(fileNmm).forward(request, response);
	}
	
	public static int parseStringToInt(String st) {
		try {
			return Integer.parseInt(st);
		} catch(Exception e) {
			return 0;
		}
	}
	
	public static int getParamInt(String key, HttpServletRequest req) {
		String strVal = req.getParameter(key);
		int intVal = parseStringToInt(strVal);
		return intVal;
	}
}
