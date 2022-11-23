import java.sql.*;

public class CreateTable {

	public static void main(String[] args) {
		try {
			
			  Class.forName("com.mysql.jdbc.Driver"); Connection con =
			  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/youtube", "root","");
			 
			/*
			 * ConnectionProvider con = new ConnectionProvider();
			 * ConnectionProvider.getConnection();
			 */

			String q = "Create table images1(tid int(10) primary key auto_increment,pic longblob)";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(q);
			System.out.println("table created in database...");
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
