package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.UpcomingFlightsBean;
import util.DBQueries;
import util.DBUtil;

public class UpcomingFlightsDao {
	public List<UpcomingFlightsBean> getUpcomingFlights(String username){
		List<UpcomingFlightsBean> mylist = new ArrayList<>();
		Connection conn = null;
		try {
			conn = DBUtil.ConnectionManager();
			PreparedStatement ps = conn.prepareStatement(DBQueries.UPCOMING_FLIGHTS);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				mylist.add(new UpcomingFlightsBean(rs.getString("flight_no"), rs.getString("pnr"), rs.getInt("booking_id"), rs.getString("source"), rs.getString("departure_time"), rs.getString("destination"), rs.getString("arrival_time"), rs.getString("duration"), rs.getDate("journey_date"), rs.getString("passenger_name")));
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("Exception in upcoming flights dao"+e);
		}
		finally {
			try {
				conn.close();
				System.out.println("Successfully closed connection");
			}
			catch(Exception e) {
				System.out.println("Exception in closing connection"+e);
			}
		}
		return mylist;
	}
}
