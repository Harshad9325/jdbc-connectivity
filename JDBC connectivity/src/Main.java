import java.sql.*;
import java.io.*;
public class Main {

	public static void main(String[] args) {
	try {
		/*
		 * ConnectionProvider con = new ConnectionProvider();
		 * ConnectionProvider.getConnection();
		 */
		
		  Class.forName("com.mysql.jdbc.Driver");
		  
		  Connection con=
		  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/youtube","root","");
		 
		 
    	String q="insert into table1(tcity) values(?)";
    	PreparedStatement pstmt=con.prepareStatement(q); 
    	FileInputStream fis=new FileInputStream("pexels-yurii-hlei-1545743 (1).jpg");
    	pstmt.setBinaryStream(1,fis,fis.available());
    	pstmt.executeUpdate();
    	System.out.println("pic inserted succusesfully..!!");
    	con.close();
    	pstmt.executeUpdate(); 
	}catch(Exception e) {
	e.printStackTrace();
	}
	
	
		
	}

}
