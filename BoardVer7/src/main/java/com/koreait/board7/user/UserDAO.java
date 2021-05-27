package com.koreait.board7.user;

import java.sql.*;

import com.koreait.board7.DBUtils;

public class UserDAO {
	public static UserEntity selUser(UserEntity param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		UserEntity result = null;
		
		String sql = "SELECT iuser, uid, upw, unm, profileImg FROM t_user WHERE uid = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();
			if(rs.next()) {
				int iuser = rs.getInt("iuser");
				String uid = rs.getString("uid");
				String upw = rs.getString("upw");
				String unm = rs.getString("unm");
				result = new UserEntity();
				result.setIuser(iuser);
				result.setUid(uid);
				result.setUpw(upw);
				result.setUnm(unm);
			    result.setProfileImg(rs.getString("profileImg"));
			}
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	public static int selIdChk(String uid) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT uid FROM t_user WHERE uid = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, uid.trim());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = 1;
			} 
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
}
