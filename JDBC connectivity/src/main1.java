

import java.io.*;
import java.sql.*;
import javax.swing.*;

public class main1 {

	public static void main(String[] args) {

		try {
			/* ConnectionProvider.getConnection(); */

			
			  Class.forName("com.mysql.jdbc.Driver");
			  @SuppressWarnings("unused")
			Connection con =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/youtube","root","");
			 

			String q = "insert into image(pic) values(?)";
			PreparedStatement pstmt = ConnectionProvider.getConnection().prepareStatement(q);
			JFileChooser jfc = new JFileChooser();
			jfc.showOpenDialog(null);
			File f = jfc.getSelectedFile();
			FileInputStream fis = new FileInputStream(f);
			pstmt.setBinaryStream(1, fis, fis.available());

			pstmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "succesfull.....");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
