package com.koreait.board7.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.koreait.board7.DBUtils;

public class BoardDAO {
	public static List<BoardDomain> selBoardList(){
		List<BoardDomain> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT A.iboard, A.title, B.unm as writerNm, A.regdt, A.iuser "
				+ " FROM t_board A "
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " ORDER BY iboard DESC ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
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