import java.sql.*;

public class FirstJDBC {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/youtube", "root", "");

			if (con.isClosed()) {
				System.out.println("connection is closed");
			} else {
				System.out.println("connection created...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
