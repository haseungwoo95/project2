package com.koreait.board5.board;

import java.sql.*;
import java.util.*;

import com.koreait.board5.DBUtils;

public class BoardDAO {
	public static int cntLike(int iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int sum = 0;
		String sql = "SELECT * FROM t_board_like WHERE iboard = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();
			while(rs.next()) {
				sum = sum + 1;
			}
			return sum;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static void delBoardLike(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM t_board_like WHERE iboard = ? AND iuser = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			ps.setInt(2, vo.getIuser());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static int searchLike(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM t_board_like WHERE iboard = ? AND iuser = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			ps.setInt(2, vo.getIuser());
			rs = ps.executeQuery();
			if(rs.next()) {
				return 1;
			} else {
				return 0;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	public static void boardLike(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO t_board_like (iboard, iuser) VALUES (?,?)";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			ps.setInt(2, vo.getIuser());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
	public static int modBoard(BoardVO vo) {
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
	public static BoardVO selBoard(int iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT A.iboard, A.title, B.unm, A.regdt, A.ctnt, A.iuser FROM t_board A LEFT JOIN t_user B ON A.iuser = B.iuser WHERE iboard = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();
			BoardVO vo = new BoardVO();
			if(rs.next()) {		
				vo.setIboard(iboard);
				vo.setTitle(rs.getString("title"));
				vo.setUnm(rs.getString("unm"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setIuser(rs.getInt("iuser"));
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
	public static List<BoardVO> selBoardList(){
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT A.iboard, A.title, B.unm, A.regdt, A.iuser FROM t_board A LEFT JOIN t_user B ON A.iuser = B.iuser ORDER BY iboard DESC";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIuser(rs.getInt("iuser"));
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setUnm(rs.getString("unm"));
				vo.setRegdt(rs.getString("regdt"));
				
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
	public static int writeBoard(BoardVO vo) {
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
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}
}
