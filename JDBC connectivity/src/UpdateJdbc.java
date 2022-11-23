
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;

public class UpdateJdbc {
	public static void main(String[] args) {
		try {
			ConnectionProvider con = new ConnectionProvider();
			ConnectionProvider.getConnection();

			String q = "update table1 set tname=?,tcity=? where tid=?";
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter new tname:");
			String tname = br.readLine();

			System.out.println("Enter new tcity:");
			String tcity = br.readLine();

			System.out.println("Enter the tid:");
			int tid = Integer.parseInt(br.readLine());

			@SuppressWarnings("static-access")
			PreparedStatement pstmt = con.getConnection().prepareStatement(q);

			pstmt.setString(1, tname);
			pstmt.setString(2, tcity);
			pstmt.setInt(3, tid);
			pstmt.executeUpdate();
			System.out.println("done.....");
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
