package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.BookFlightBean;
import util.DBQueries;
import util.DBUtil;

public class BookFlightDao {
	
	public int getCost(String flightNo) {
		Connection conn = null;
		BookFlightBean bean = new BookFlightBean();
		int cost = 0;
		try {
		conn = DBUtil.ConnectionManager();
		PreparedStatement ps = conn.prepareStatement(DBQueries.GET_COST_OF_FLIGHT);
		ps.setString(1, flightNo);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			bean.setCost(rs.getInt("cost"));
		}
		
		cost = bean.getCost();
		}
		catch(Exception e) {
			System.out.println("Exception in getCost function "+e);
		}
		finally {
			try {
				conn.close();
				System.out.println("Successfully closed connection");
			}
			catch(Exception e) {
				System.out.println("Exception in closing connection "+e);
			}
		}
		return cost;
	}
	
}
