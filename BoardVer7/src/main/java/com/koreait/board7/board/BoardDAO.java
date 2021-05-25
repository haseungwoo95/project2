package com.koreait.board7.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.koreait.board7.DBUtils;

public class BoardDAO {
	public static BoardDomain selBoard(BoardDTO param){
		BoardDomain vo = new BoardDomain();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT A.iboard, A.title, B.unm as writerNm, A.regdt, A.iuser, A.ctnt "
				   + " FROM t_board A "
				   + " INNER JOIN t_user B "
				   + " ON A.iuser = B.iuser "
				   + " WHERE A.iboard = ? ";
			
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();
			
			if(rs.next()) {			
				vo.setIuser(rs.getInt("iuser"));
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setWriterNm(rs.getString("writerNm"));	
				vo.setCtnt(rs.getString("ctnt"));
			}
			return vo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	public static int selPagingCnt(BoardDTO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT CEIL(COUNT(iboard) / ?) ")
		.append(" FROM t_board A ")
		.append(" INNER JOIN t_user B ")
		.append(" ON A.iuser = B.iuser ");
		
		if(param.getSearchType() > 0) {
			sb.append(" WHERE ");
		}
		switch(param.getSearchType()) {
		case 1://제목+내용
			sb.append("A.title LIKE '%")
			.append(param.getSearchText())
			.append("%' OR A.ctnt LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		case 2://제목
			sb.append("A.title LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		case 3://내용
			sb.append("A.ctnt LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		case 4://글쓴이
			sb.append("B.num LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;	
		}
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sb.toString());
			ps.setInt(1, param.getRecordCnt());
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}
	
	public static List<BoardDomain> selBoardList(BoardDTO param){
		List<BoardDomain> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT A.iboard, A.title, B.unm as writerNm, A.regdt, A.iuser "
				   + " FROM t_board A "
				   + " INNER JOIN t_user B "
				   + " ON A.iuser = B.iuser ";
			
		switch(param.getSearchType()) {
		case 1://제목+내용
			sql += String.format("WHERE A.title LIKE '%%%s%%' OR A.ctnt LIKE '%%%s%%' "
					, param.getSearchText(), param.getSearchText());
			break;
		case 2://제목
			sql += String.format("WHERE A.title LIKE '%%%s%%' "
					, param.getSearchText());
			break;
		case 3://내용
			sql += String.format("WHERE A.ctnt LIKE '%%%s%%' "
					, param.getSearchText());
			break;
		case 4://글쓴이
			sql += String.format("WHERE B.unm LIKE '%%%s%%' ", param.getSearchText());
			break;	
		}
			sql	+= "ORDER BY iboard DESC "
				+ " LIMIT ?, ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getStartIdx());
			ps.setInt(2, param.getRecordCnt());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDomain vo = new BoardDomain();
				vo.setIuser(rs.getInt("iuser"));
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setWriterNm(rs.getString("writerNm"));
				
				list.add(vo);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
}