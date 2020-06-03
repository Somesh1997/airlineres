package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import bean.PaymentProcessBean;
import util.DBQueries;
import util.DBUtil;

public class PaymentProcessDao {
	public int insertBookingDetails(List<PaymentProcessBean> mylist) {
		int result = 0;
		int count = 0;
		Connection conn = null;
		try {
			conn = DBUtil.ConnectionManager();
			PreparedStatement ps = conn.prepareStatement(DBQueries.INSERT_BOOKING_DETAILS);
			for (PaymentProcessBean bean : mylist) {
				ps.setString(1, bean.getPNR());
				ps.setDate(2, bean.getBookingDate());
				ps.setDate(3, bean.getJourneyDate());
				ps.setInt(4, bean.getAmount());
				ps.setString(5, bean.getPassengerName());
				ps.setInt(6, bean.getAge());
				ps.setString(7, bean.getCategory());
				ps.setString(8, bean.getFlightNo());
				ps.setString(9, bean.getUserName());
				ps.setInt(10, bean.getSeatNo());
				ps.setString(11, "upcoming");
				count = ps.executeUpdate();
				result = result + count;
			}
		}
		catch(Exception e) {
			System.out.println("Exception in insert booking details "+e);
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
		return result;
	}
}
