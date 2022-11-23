import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ValueInsert {

	public static void main(String[] args) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/youtube", "root", "");

			/*
			 * ConnectionProvider con = new ConnectionProvider();
			 * ConnectionProvider.getConnection();
			 */

			String q = "INSERT INTO  table1 values(4,'durga','delhi')";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(q);
			System.out.println("values inserted succsesfully.....");
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
