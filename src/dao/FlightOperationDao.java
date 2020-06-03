package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.FlightOperationBean;
import util.DBQueries;
import util.DBUtil;

public class FlightOperationDao {
	
	public List<FlightOperationBean> showFlights(){
		List<FlightOperationBean> mylist = new ArrayList<>();
		Connection conn = null;
		
		try {
			conn = DBUtil.ConnectionManager();
			PreparedStatement ps = conn.prepareStatement(DBQueries.SHOW_FLIGHTS);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				mylist.add(new FlightOperationBean(rs.getInt("route_id"), rs.getString("flight_no"), rs.getInt("capacity"), rs.getString("source"), rs.getString("departure_time"), rs.getString("destination"), rs.getString("arrival_time"), rs.getString("duration"), rs.getInt("cost")));
			}
			rs.close();
			
		}
		catch(Exception e) {
			System.out.println("Exception in show Flights function"+e);
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
		
		return mylist;
	}
	
}
