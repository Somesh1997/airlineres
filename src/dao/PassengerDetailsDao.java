package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.PassengerDetailsBean;
import util.DBQueries;
import util.DBUtil;

public class PassengerDetailsDao {
	public List<PassengerDetailsBean> showPassengersDetails(){
		List<PassengerDetailsBean> mylist = new ArrayList<>();
		Connection conn = null;
		
		try {
			conn = DBUtil.ConnectionManager();
			PreparedStatement ps = conn.prepareStatement(DBQueries.VIEW_PASSENGER_DETAILS);
			ps.setString(1, "upcoming");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				mylist.add(new PassengerDetailsBean(rs.getString("passenger_name"), rs.getInt("age"), rs.getInt("seat_no"), rs.getDate("booking_date"), rs.getString("flight_no"), rs.getString("departure_time"), rs.getString("arrival_time"), rs.getString("user_name")));
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("Exception in showPassengersDetails function "+e);
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception e) {
				System.out.println("Exception in closing connection "+e);
			}
		}
		return mylist;
	}
}
