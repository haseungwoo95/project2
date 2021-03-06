package com.koreait.board4.board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board4.DBUtils;

public class BoardDAO {
	public static int insertBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO t_board (title, ctnt, iuser) VALUES (?,?,?)";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIuser());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	public static List<BoardVO> selBoardList(){
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT A.iboard, A.title, B.unm, A.regdt FROM t_board A LEFT JOIN t_user B ON A.iuser = B.iuser ORDER BY A.iboard DESC";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();		
				vo.setTitle(rs.getString("title"));
				vo.setIboard(rs.getInt("iboard"));
				vo.setUnm(rs.getString("unm"));
				vo.setRegdt(rs.getString("regdt"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}
	
	public static BoardVO selBoard(int iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO vo = null;
		String sql = "SELECT A.title, B.unm, A.regdt, A.ctnt, A.iuser "
				+ " FROM t_board A LEFT JOIN t_user B ON A.iuser = B.iuser "
				+ " WHERE iboard = ? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new BoardVO();
				vo.setIboard(iboard);
				vo.setTitle(rs.getString("title"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setUnm(rs.getString("unm"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
			}
			return vo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return vo;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	public static int delBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM t_board WHERE iboard = ? AND iuser = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			ps.setInt(2, vo.getIuser());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static int updBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE t_board SET title = ?, ctnt = ? WHERE iboard = ? AND iuser = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			ps.setInt(4, vo.getIuser());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}
}