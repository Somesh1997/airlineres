package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String username = "scott";
	private static final String password = "tiger";
	private static Connection conn = null;
	
	//method to connect with the database
	public static Connection ConnectionManager() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Class Found");
			try {
				System.out.println("Connecting with the database....");
				conn = DriverManager.getConnection(url, username, password);
				System.out.println("Connection established "+conn);
			}
			catch(SQLException e)
			{
				System.out.println("Connection not established due to "+e);
			}
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Driver Class not found");
		}
		return conn;
	}
	
}
