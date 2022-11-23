import java.sql.*;
import java.io.*;
class InsertLongImages
{
	public static void main(String[] args) 
	{
	    try 
	    {
             Class.forName("com.mysql.jdbc.Driver");
        	
        	Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/youtube","root",""); 

        	String q="insert into images1(pic) values(?)";
        	PreparedStatement pstmt=con.prepareStatement(q); 
        	FileInputStream fis=new FileInputStream("mypic3.png");
        	pstmt.setBinaryStream(1,fis,fis.available());
        	pstmt.executeUpdate();
        	System.out.println("pic inserted succusesfully..!!");
        	con.close();

	    }catch(Exception e)
	    {
          e.printStackTrace();
	    }
	}
}