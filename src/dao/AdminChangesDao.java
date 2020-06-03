package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.AdminChangesBean;
import util.DBQueries;
import util.DBUtil;

public class AdminChangesDao {
	public int updateFlightInfo(AdminChangesBean bean) {
		int result = 0;
		Connection conn = null;
		try {
			conn = DBUtil.ConnectionManager();
			PreparedStatement ps = conn.prepareStatement(DBQueries.UPDATE_FLIGHT_INFO);
			ps.setString(1, bean.getDuration());
			ps.setString(2, bean.getDeparture());
			ps.setString(3, bean.getArrival());
			ps.setInt(4, bean.getCapacity());
			ps.setInt(5, bean.getCost());
			ps.setString(6, bean.getFlightNo());
			result = ps.executeUpdate();
			System.out.println(result);
		}
		catch(Exception e) {
			System.out.println("Exception in function updateFlightInfo "+e);
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception e) {
				System.out.println("Exception in closing connection "+e);
			}
		}
		return result;
	}
}
