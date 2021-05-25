package com.koreait.board7.cmt;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.koreait.board7.MyUtils;


@WebServlet("/board/cmtInsSel")
public class BoardCmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIboard(iboard);
		
		List<BoardCmtDomain> list = BoardCmtDAO.selBoardCmtList(param);
		
		String json = "[";
		for(int i=0; i<list.size(); i++) {
			String item = "{";
			BoardCmtDomain vo = list.get(i);
			item += "\"icmt\":";
			item += vo.getIcmt();
			item += "\"iboard\":";
			item += vo.getIboard();
			item += "}";
			json += item;
		}
//		Gson gson = new Gson();
//		String json = gson.toJson(list);
//		
//		response.getWriter()
//		.append(json);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		String cmt = request.getParameter("cmt");
		int iuser = MyUtils.getLoginUserPk(request);
		
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIboard(iboard);
		param.setCmt(cmt);
		param.setIuser(iuser);
		
		int result = BoardCmtDAO.insBoardCmt(param);
		
		response.getWriter()
		.append("{")
		.append("\"result\":")
		.append(String.valueOf(result))
		.append("}")
		.flush();
		
	}

}
