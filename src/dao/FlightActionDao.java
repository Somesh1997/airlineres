package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.FlightActionBean;
import util.DBQueries;
import util.DBUtil;

public class FlightActionDao {
	
	public FlightActionBean showFlightDetail(String flightno) {
		FlightActionBean bean = null;
		Connection conn = null;
		try {
			conn = DBUtil.ConnectionManager();
			PreparedStatement ps = conn.prepareStatement(DBQueries.VIEW_FLIGHT);
			ps.setString(1, flightno);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				bean = new FlightActionBean(rs.getInt("route_id"), rs.getString("flight_no"), rs.getInt("capacity"), rs.getString("source"), rs.getString("departure_time"), rs.getString("destination"), rs.getString("arrival_time"), rs.getString("duration"), rs.getInt("cost")); 
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("Exception in showFlightDetail function"+e);
		}
		finally {
			try {
				conn.close();
				System.out.println("Closed connection successfully");
			}
			catch(Exception e) {
				System.out.println("Exception in closing connection"+e);
			}
		}
		return bean;
	}
	
	public int deleteFlight(String flightNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = DBUtil.ConnectionManager();
			PreparedStatement ps = conn.prepareStatement(DBQueries.DELETE_FLIGHT);
			ps.setString(1, flightNo);
			result = ps.executeUpdate();
			System.out.println(result);
		}
		catch(Exception e) {
			System.out.println("Exception in showFlightDetail function"+e);
		}
		finally {
			try {
				conn.close();
				System.out.println("Closed connection successfully");
			}
			catch(Exception e) {
				System.out.println("Exception in closing connection"+e);
			}
		}
		
		return result;
	}
	
}
