package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.LoginBean;
import util.DBQueries;
import util.DBUtil;

public class LoginDao {
	public LoginBean checkLoginDetails(LoginBean bean) throws SQLException
	{
		Connection conn = null;
		LoginBean getValue = new LoginBean();		
		try {
			conn = DBUtil.ConnectionManager();
			PreparedStatement ps = conn.prepareStatement(DBQueries.LOGIN);
			ps.setString(1, bean.getUsername());
			ps.setString(2, bean.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next() == false) {
				getValue.setIsAdmin(3);
			}
			else {
				do {
					getValue.setFirstName(rs.getString(1));
					getValue.setLastName(rs.getString(2));
					getValue.setIsAdmin(rs.getInt(3));
				}
				while(rs.next());
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally {
			conn.close();
			System.out.println("Successfully closed connection");
		}
		return getValue;
	}

//	public List<LoginBean> showSource(){
//		List<LoginBean> mylist = new ArrayList<LoginBean>();
//		LoginBean bean = new LoginBean();
//		Connection conn = null;
//		try {
//			conn = DBUtil.ConnectionManager();
//			PreparedStatement ps = conn.prepareStatement(DBQueries.SELECT_SOURCE);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				mylist.add(rs.getString("source"));
//			}
//		}
//		catch(Exception e){
//			System.out.println("Exception in showSourceDes function "+e);
//		}
//		finally {
//			conn.close();
//			System.out.println("Successfully closed connection");
//		}
//		
//		
//		return mylist;
//	}
}
