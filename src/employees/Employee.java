package employees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import app.DbConn;

public class Employee {
	public int employeeID;
	private String name;
	private String address;
	private String NINO;
	private String bankAccount;
	private float startSalary;
	private String department;

	Connection connection = null;
	PreparedStatement preparedStatement = null;

	public Employee() {

		employeeID++;
	}

	public Employee(String name, String address, String NINO,
			String bankAccount, float startSalary, String department) {
		super();
		this.name = name;
		this.address = address;
		this.NINO = NINO;
		this.bankAccount = bankAccount;
		this.startSalary = startSalary;
		this.department = department;

	}

	public Employee(int employeeID) {

		this.employeeID = employeeID;
	}

	public Employee(int employeeID, String name) {
		this(employeeID);
		this.name = name;
	}

	public Employee(int employeeID, String name, String address) {
		this(employeeID, name);
		this.address = address;
	}

	public Employee(int employeeID, String name, String address,
			String bankAccount) {
		this(employeeID, name, address);
		this.bankAccount = bankAccount;
	}

	public Employee(int employeeID, String name, String address,
			String bankAccount, float startSalary) {
		this(employeeID, name, address, bankAccount);
		this.startSalary = startSalary;
	}

	public Employee(int employeeID, String name, String address,
			String bankAccount, float startSalary, String department) {
		this(employeeID, name, address, bankAccount, startSalary);
		this.department = department;
	}

	public Employee(int employeeID, String name, String address,
			String bankAccount, float startSalary, String department,
			String NINO) {
		this(employeeID, name, address, bankAccount, startSalary, department);
		this.NINO = NINO;
	}

	public String getNINO() {
		return NINO;
	}

	public void setNINO(String NINO) {
		this.NINO = NINO;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", name=" + name
				+ ", address=" + address + ", bankAccount=" + bankAccount
				+ ", startSalary=" + startSalary + ", department=" + department
				+ "]";
	}

	public float getStartSalary() {
		return startSalary;
	}

	public void setStartSalary(float startSalary) {
		this.startSalary = startSalary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	// INSERT EMPLOYEE
	
	 public  void addEmployee(Employee myEmployee) { 
	 try{
	 Class.forName("com.mysql.jdbc.Driver"); 
	 connection = DriverManager.getConnection
	 ("jdbc:mysql://localhost/Nemesis","HRuser","Password1");
	 System.out.println("Connected"); 
	 preparedStatement = connection.prepareStatement("INSERT INTO Employee(Name, Address, NINO, Bank_Acc, Starting_Salary, Department) VALUES (?,?,?,?,?,?)");
	  preparedStatement.setString(1, name); 
	  preparedStatement.setString(2,address); 
	  preparedStatement.setString(3, NINO);
	 preparedStatement.setString(4, bankAccount);
	 preparedStatement.setFloat(5, startSalary);
	 preparedStatement.setString(6, department);
	  preparedStatement.executeUpdate();
	  
	  }catch (Exception ex) { System.out.println("SQLException: " +
	  ex.getMessage()); System.out .println("SQLState: " + ((SQLException)
	  ex).getSQLState()); System.out.println("VendorError: " + ((SQLException)
	  ex).getErrorCode()); } }
	 
/*	public void addEmployee(Employee myEmployee) {
		String SQL = "";

		SQL += "INSERT INTO `Employee` (Name, Address, NINO, Bank_Acc, Starting_Salary, Department) VALUES (?,?,?,?,?,?)";
		SQL += "VALUES (" + "'" + myEmployee.getName() + "'";
		SQL += "," + myEmployee.getAddress();
		SQL += "," + myEmployee.getNINO();
		SQL += "," + myEmployee.getBankAccount();
		SQL += "," + myEmployee.getStartSalary();
		SQL += "," + "'" + myEmployee.getDepartment() + "');";
		DbConn.dbConnection(SQL);
		
	}*/

	// select all employees
	public void SelectEmployees() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/Nemesis", "HRuser","Password1");
			System.out.println("Connected");
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("Select * from Employee limit 5");
			ResultSetMetaData rsmd = rs.getMetaData();

			System.out.println("querying all FROM Employees");
			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1)
						System.out.print(",  ");
					String columnValue = rs.getString(i);
					System.out.print(columnValue + " " + rsmd.getColumnName(i));
				}
				System.out.println("");
			}

		} catch (ClassNotFoundException error1) {
			System.out.println("Error:" + error1.getMessage());
		} catch (SQLException error) {
			System.out.println("Error:" + error.getMessage());
		}

	}

public void SelectSalesEmployees(){
	try{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/Nemesis","HRuser","Password1");
		System.out.println("Connected");
	Statement st = connection.createStatement();
	ResultSet rs = st.executeQuery( "Select Employee.Name, Commission_Rate, Sales_Total  from Employee, Sales_Employee where Sales_Employee.Employee_ID = Employee.Employee_ID; ");
	ResultSetMetaData rsmd = rs.getMetaData();
	
	System.out.println("querying all FROM Sales Employees");
	 
	    int columnsNumber = rsmd.getColumnCount();
	    while (rs.next()) {
	        for (int i = 1; i <= columnsNumber; i++) {
	            if (i > 1) System.out.print(",  ");
	            String columnValue = rs.getString(i);
	            System.out.print(columnValue + " " + rsmd.getColumnName(i));
	        }
	        System.out.println("");
	    }
	    
	
	}catch (ClassNotFoundException error1){
	System.out.println("Error:" +error1.getMessage());			
	}
	catch (SQLException error){
		System.out.println("Error:" +error.getMessage());
	}
}
public void SelectsAvailableEmployees()
{
	try{
	Class.forName("com.mysql.jdbc.Driver");
	connection = DriverManager.getConnection("jdbc:mysql://localhost/Nemesis","HRuser","Password1");
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

}//end
