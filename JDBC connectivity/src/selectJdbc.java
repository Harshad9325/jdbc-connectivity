import java.sql.*;
public class selectJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			       Connection con=ConnectionProvider.getConnection();
			       String q="select * from table1";
			       
			      Statement stmt= con.createStatement();
			      ResultSet set=stmt.executeQuery(q);
			      
			      while(set.next())
			      {
			    	  int tid=set.getInt(1);
			    	  String tname=set.getString(2);
			    	  String tcity=set.getString(3);
			    	  
			    	  System.out.println(tname+" : "+tid+" : "+tcity);
			    	 
			      }
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
