package com.koreait.board5.cmt;

import java.sql.*;
import java.util.*;

import com.koreait.board5.DBUtils;

public class CmtDAO {
	public static void updCmt(CmtVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE t_board_cmt SET cmt = ? WHERE icmt = ? AND iuser = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getCmt());
			ps.setInt(2, vo.getIcmt());
			ps.setInt(3, vo.getIuser());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	} 
	public static void delCmt(CmtVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM t_board_cmt WHERE icmt = ? AND iuser = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIcmt());
			ps.setInt(2, vo.getIuser());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
	public static List<CmtVO> selCmtList(CmtVO vo){
		List<CmtVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT A.icmt, A.cmt, B.unm, A.regdate , A.iuser "
				+ " FROM t_board_cmt A "
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " WHERE A.iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CmtVO cmt = new CmtVO();
				cmt.setCmt(rs.getString("cmt"));
				cmt.setUnm(rs.getString("unm"));
				cmt.setRegdate(rs.getString("regdate"));
				cmt.setIcmt(rs.getInt("icmt"));
				cmt.setIuser(rs.getInt("iuser"));
				list.add(cmt);
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
	public static void insCmt(CmtVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO t_board_cmt (cmt, iboard, iuser) VALUES (?,?,?)";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getCmt());
			ps.setInt(2, vo.getIboard());
			ps.setInt(3, vo.getIuser());
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
}
