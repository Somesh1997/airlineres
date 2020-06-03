package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.SignUpBean;
import util.DBQueries;
import util.DBUtil;

/**
 * @author Ankit Shrivastav
 * @version 1.1.0
 * http://demo.itsolutionstuff.com/itemCRUD
 * 
 */
public class SignUpDao {
	public int insertData(SignUpBean bean) throws SQLException
	{
		Connection conn = null;
		int result = 0;
		try {
			conn = DBUtil.ConnectionManager();
			conn.setAutoCommit(false);		//setting the auto commit to false
			
			PreparedStatement ps = conn.prepareStatement(DBQueries.INSERT_SIGNUP);
			ps.setString(1, bean.getFirst_name());
			ps.setString(2, bean.getLast_name());
			ps.setString(3, bean.getUser_name());
			ps.setString(4, bean.getPassword());
			ps.setString(5, bean.getEmail());
			ps.setDate(6,bean.getDob());	//ps.setDate(6, (Date) bean.getDob()); TO_DATE('21/11/2019','dd/mm/yyyy')
			ps.setString(7, bean.getGender());
			ps.setInt(8, 1);
			ps.setLong(9, bean.getMobile());
			
			result = ps.executeUpdate();	//will return the no. of rows affected
			conn.commit();		//commiting the connection
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			conn.close();	//closing the connection
		}
		return result;
	}
	
}
