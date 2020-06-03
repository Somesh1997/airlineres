package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.AddFlightBean;
import util.DBQueries;
import util.DBUtil;

public class AddFlightDao {
	
	public int checkExistingRoute(String source, String destination) {
		Connection conn = null;
		int status = 0;
		try {
			conn = DBUtil.ConnectionManager();
			PreparedStatement ps = conn.prepareStatement(DBQueries.CHECK_ROUTES);
			ps.setString(1, source);
			ps.setString(2, destination);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				status = rs.getInt("route_id");
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("Exception in function checkExistingRoute"+e); 
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception e) {
				System.out.println("Exception in closing"+e);
			}
		}
		
		return status;
	}
	
	
	public int addNewFlight(AddFlightBean bean) {
		int result = 0;
		Connection conn = null;
		try {
			conn = DBUtil.ConnectionManager();
			PreparedStatement ps = conn.prepareStatement(DBQueries.ADD_FLIGHT_SECTORS);
			ps.setInt(1, bean.getRouteID());
			ps.setString(2, bean.getSource());
			ps.setString(3, bean.getDestination());
			result = ps.executeUpdate();
			
			ps = conn.prepareStatement(DBQueries.ADD_FLIGHT);
			ps.setString(1, bean.getFlightno());
			ps.setString(2, bean.getFlightName());
			ps.setString(3, bean.getDuration());
			ps.setString(4, bean.getDeparture());
			ps.setString(5, bean.getArrival());
			ps.setInt(6, bean.getCapacity());
			ps.setInt(7, bean.getCost());
			ps.setInt(8, bean.getRouteID());
			result = result + ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("Exception in function checkExistingRoute"+e); 
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception e) {
				System.out.println("Exception in closing"+e);
			}
		}
		
		return result;
	}

}
