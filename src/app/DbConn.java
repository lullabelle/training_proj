package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DbConn {
	public static void main(String[] args) {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	try{
		//makes the connection to the driver
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/Nemesis","root","Staged00r1");
		
	}

	catch (ClassNotFoundException error1){
		System.out.println("Error:" +error1.getMessage());			
	}
	catch (SQLException error){
		System.out.println("Error:" +error.getMessage());
	}
	finally {//finally block will execute if nothing above works
		if (connection !=null)try{connection.close();}
		catch (SQLException ignore){//closes DB conn	
		}
		if (preparedStatement!=null)try{
			preparedStatement.close();
			}
		catch (SQLException ignore){
			
		}
		
	}
	}
	

	
		}

	
	
	
