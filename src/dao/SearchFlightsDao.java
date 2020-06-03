package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.SearchFlightsBean;
import util.DBQueries;
import util.DBUtil;

public class SearchFlightsDao {
	
	public List<SearchFlightsBean> getFlightsDetails(SearchFlightsBean bean)
	{
		List<SearchFlightsBean> myList = new ArrayList<>();
		Connection conn = null;
		try {
			conn = DBUtil.ConnectionManager();
			PreparedStatement ps = conn.prepareStatement(DBQueries.FETCH_FLIGHTS);
			ps.setString(1, bean.getFrom());
			ps.setString(2, bean.getTo());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				myList.add(new SearchFlightsBean(rs.getString("flight_no"), rs.getString("flight_name"), rs.getString("source"), rs.getString("departure_time"), rs.getString("destination"), rs.getString("arrival_time"), rs.getString("duration"), rs.getInt("cost")));
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("Exception thrown in getFlightsDetails function "+e);
		}
		finally {
			try {
				conn.close();
				System.out.println("Successfully closed connection");
			}
			catch(SQLException e) {
				System.out.println("Exception in closing connection "+e);
			}
		}
		
		return myList;
	}
}
