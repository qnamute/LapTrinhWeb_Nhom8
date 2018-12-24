package DB;
import java.sql.*;
import java.time.LocalDate;

public class DBConnection {
	public static Connection CreateConnection(){
		Connection conn= null;

		String url="jdbc:mysql://localhost:3306/Webdatabase";
		String username="root";
		String password="1234";

		try {
			// load Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// create connection
			conn = DriverManager.getConnection(url,username,password);
			
			System.out.println("Connected successfully...");
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Error connection " + ex);
		}

		// create connection
		return conn;
	}
	
	public static void main(String[] args)
	{
		LocalDate dt;
		dt = java.time.LocalDate.now();
		
		String date = dt.toString();
		
		int test = Integer.parseInt(date);
		
		System.out.println(test);
		
		DBConnection.CreateConnection();		
	}	
}

