package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.ChangePassAdminBean;
import util.DBQueries;
import util.DBUtil;

public class ChangePassAdminDao {
	
	public int CheckOldPassword(ChangePassAdminBean bean) {
		Connection conn = null;
		int count = 0;
		try {
			conn = DBUtil.ConnectionManager();
			PreparedStatement ps = conn.prepareStatement(DBQueries.CHECK_LOGIN_CUSTOMER_ADMIN);
			ps.setString(1, bean.getUsername());
			ps.setString(2, bean.getOldPass());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				count++;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				conn.close();
				System.out.println("Connection closed from check function");
			} catch (SQLException e) {
				System.out.println("Exception in closing the connection"+e);
			}
		}

		return count;
	}
	
	public int updateNewPassword(ChangePassAdminBean bean) {
		Connection conn = null;
		int result = 0;
		try {
		conn = DBUtil.ConnectionManager();
		PreparedStatement ps = conn.prepareStatement(DBQueries.UPDATE_PASSWORD);
		ps.setString(1, bean.getNewPass());
		ps.setString(2, bean.getUsername());
		
		result = ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("Exception in updateNewPass function"+e);
		}
		finally {
			try {
				conn.close();
				System.out.println("Connection closed from update function");
			}
			catch(SQLException e) {
				System.out.println("Exception in closing connection"+e);
			}
		}
		return result;
	}
}
