package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBQueries;
import util.DBUtil;

public class GenerateSeatNumberDao {
	public List<Integer> getFilledSeats(String flightNo, Date journeyDate) {
		List<Integer> mylist = new ArrayList<Integer>();
		Connection conn = null;
		try {
			conn = DBUtil.ConnectionManager();
			PreparedStatement ps = conn.prepareStatement(DBQueries.GET_FILLED_SEATS);
			ps.setDate(1, journeyDate);
			ps.setString(2, flightNo);
			ps.setString(3, "upcoming");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				mylist.add(rs.getInt("SEAT_NO"));
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("Exception in generate seat number dao func "+e);
		}
		finally {
			try {
				conn.close();
				System.out.println("Successfully closed connection");
			}
			catch(Exception e) {
				System.out.println("Exception in closing connection at gen seat number"+e);
			}
		}
		return mylist;
	}
}
