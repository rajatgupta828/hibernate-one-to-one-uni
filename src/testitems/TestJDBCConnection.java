package testitems;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBCConnection {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String userName = "hbstudent";
		String password = "hbstudent";
		
		try {
			
			System.out.println("Connecting to the database");
			Connection conn = DriverManager.getConnection(url,userName,password);
			System.out.println("Connection established : " + conn);
			
			
		}catch (Exception e) {
			System.out.println( " JDBC Exception" + e.toString());
		}
		
	}

}
