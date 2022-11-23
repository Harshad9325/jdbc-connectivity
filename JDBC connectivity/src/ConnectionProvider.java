

import java.sql.*;

public class ConnectionProvider {

	private static Connection con;

	public static Connection getConnection() {
		try {

			if (con == null) {

				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/youtube", "root", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public PreparedStatement prepareStatement(String q) {
		// TODO Auto-generated method stub
		return null;
	}

	public Statement createStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	public Statement CreateStatement() {
		// TODO Auto-generated method stub
		return null;
	}
}
