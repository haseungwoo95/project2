package com.koreait.board7.user;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/user/mypage")
public class UserMypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("마이페이지", "user/userMypage", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadPath = request.getServletContext().getRealPath("/res/img");
		int maxFileSize = 10_485_760; //10 * 1024 * 1024 (10mb)
		MultipartRequest multi = new MultipartRequest(request, uploadPath + "/temp", maxFileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		int loginUserPk = MyUtils.getLoginUserPk(request);
		
		String targetFolder = uploadPath + "/user/" + loginUserPk;
		File folder = new File(targetFolder);
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		String fileNm = multi.getFilesystemName("profileImg");
		
		int lastDotIdx = fileNm.lastIndexOf(".");
		String ext = fileNm.substring(lastDotIdx); //확장자 구함
		
		String newFileNm = UUID.randomUUID().toString()  + ext;
		
		File imgFile = new File(uploadPath + "/temp" + "/" + fileNm);
		imgFile.renameTo(new File(targetFolder + "/" + newFileNm));
	}

}
