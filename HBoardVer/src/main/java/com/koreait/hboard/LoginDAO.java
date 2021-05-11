package com.koreait.hboard;

import java.sql.*;
import java.util.*;

public class LoginDAO {
	
	public static int cmem (LoginLO lo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO t_member(id, pw, m_name) VALUES(?,?,?)";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, lo.getId());
			ps.setString(2, lo.getPw());
			ps.setString(3, lo.getNm());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	public static LoginLO login(LoginLO lo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LoginLO log = new LoginLO();
		String sql = "SELECT id, pw FROM t_member WHERE id=? AND pw=?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, lo.getId());
			ps.setString(2, lo.getPw());
			rs = ps.executeQuery();
			if (rs.next()) {
				log.setId(rs.getString("id"));			
				return log;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}
	
	public static LoginLO chkId1(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LoginLO chkid = new LoginLO();
		String sql = "SELECT id FROM t_member WHERE id=?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				chkid.setId(rs.getString("id"));
				return chkid;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}
	
	public static int chkId2(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int x = 0;
		String sql = "SELECT id FROM t_member WHERE id=?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				x = 1;
				return x;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return 0;
	}
	
}
