package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.*;

public class DbConn {
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	public void MakeConnection()
	{
	
	try{
		//makes the connection to the driver
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/Nemesis","root","Bumblebee");
		System.out.println("Connected");
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
		}}
			
		}
	
	public void SelectEmployees()
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/Nemesis","root","Bumblebee");
		System.out.println("Connected");
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery( "Select * from Employee limit 5");
		ResultSetMetaData rsmd = rs.getMetaData();

		
		 System.out.println("querying SELECT *  Employees");
		    int columnsNumber = rsmd.getColumnCount();
		    while (rs.next()) {
		        for (int i = 1; i <= columnsNumber; i++) {
		            if (i > 1) System.out.print(",  ");
		            String columnValue = rs.getString(i);
		            System.out.print(columnValue + " " + rsmd.getColumnName(i));
		        }
		        System.out.println("");
		    }
		    
		
		}

		catch (ClassNotFoundException error1){
			System.out.println("Error:" +error1.getMessage());			
		}
		catch (SQLException error){
			System.out.println("Error:" +error.getMessage());
		}
	}
	
	// Select Employee.Name, Commission_Rate, Sales_Total  from Employee, Sales_Employee where Sales_Employee.Employee_ID = Employee.Employee_ID; 
	
	
	public void SelectSAvailableEmployees()
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/Nemesis","root","Bumblebee");
		System.out.println("Connected");
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery( "Select Employee_ID, Name , Department from Employee where Employee.Employee_ID NOT IN (Select Employee_ID from Project) Group by Department");
		ResultSetMetaData rsmd = rs.getMetaData();

		
		 System.out.println("querying SELECT * All available Sales Employees");
		    int columnsNumber = rsmd.getColumnCount();
		    while (rs.next()) {
		        for (int i = 1; i <= columnsNumber; i++) {
		            if (i > 1) System.out.print(",  ");
		            String columnValue = rs.getString(i);
		            System.out.print(columnValue + " " + rsmd.getColumnName(i));
		        }
		        System.out.println("");
		    }
		    
		
		}

		catch (ClassNotFoundException error1){
			System.out.println("Error:" +error1.getMessage());			
		}
		catch (SQLException error){
			System.out.println("Error:" +error.getMessage());
		}
	}
	
	// Select Employee_ID, Name from Employee where Employee.Employee_ID NOT IN (Select Employee_ID from Project);
	public void SelectSalesEmployees()
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/Nemesis","root","Bumblebee");
		System.out.println("Connected");
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery( "Select Employee.Name, Commission_Rate, Sales_Total  from Employee, Sales_Employee where Sales_Employee.Employee_ID = Employee.Employee_ID; ");
		ResultSetMetaData rsmd = rs.getMetaData();

		
		 System.out.println("querying SELECT * Sales Employees");
		    int columnsNumber = rsmd.getColumnCount();
		    while (rs.next()) {
		        for (int i = 1; i <= columnsNumber; i++) {
		            if (i > 1) System.out.print(",  ");
		            String columnValue = rs.getString(i);
		            System.out.print(columnValue + " " + rsmd.getColumnName(i));
		        }
		        System.out.println("");
		    }
		    
		
		}

		catch (ClassNotFoundException error1){
			System.out.println("Error:" +error1.getMessage());			
		}
		catch (SQLException error){
			System.out.println("Error:" +error.getMessage());
		}
	}
	
	
	
	
	
}

	
	
	
