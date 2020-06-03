package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DBQueries;
import util.DBUtil;

public class CancelTicketDao {
	public int updateStatus(int bookingid) {
		int result = 0;
		Connection conn = null;
		try {
			conn = DBUtil.ConnectionManager();
			PreparedStatement ps = conn.prepareStatement(DBQueries.UPDATE_STATUS);
			ps.setInt(1, bookingid);
			result = ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("exception in update status function"+e);
		}
		finally{
			try {
				conn.close();
				System.out.println("Successfully closed connection");
			}
			catch(Exception e) {
				System.out.println(""+e);
			}
		}
		return result;
	}
}
