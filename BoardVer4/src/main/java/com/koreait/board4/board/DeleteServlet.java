package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;


@WebServlet("/board/del")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int delnum = MyUtils.getParamInt("delnum", request);
		if(delnum == 1) {
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPk(request);
		
		BoardVO vo = new BoardVO();
		vo.setIboard(iboard);
		vo.setIuser(iuser);
		BoardDAO.delBoard(vo);
		

//			vo2.setIcomm(icomm);
//			if(iuser == vo.getIuser()) {
//				vo2.setIuser(iuser)
//			} else {
//				vo2.setIuser(vo.getIuser());
//			}
			
			
			
			response.sendRedirect("detail?iboard=" + iboard);
		}
	}

}
