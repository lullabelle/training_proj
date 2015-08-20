package employees;

public class Employee {
	public int employeeID;
	private String name;
	private String address;
	private int bankAccount;
	private float startSalary;
	private String department;
	
	
	
	public Employee(int employeeID) {
	
		this.employeeID = employeeID;
	}
	public Employee(int employeeID, String name) {
		this(employeeID);
		this.name= name;
	}
	
	public Employee(int employeeID, String name,String address){
		this(employeeID,name);
		this.address= address;
	}
	
	public Employee(int employeeID, String name,String address,int bankAccount){
		this(employeeID,name,address);
		this.bankAccount= bankAccount;
	}
	
	public Employee(int employeeID, String name,String address,int bankAccount, float startSalary){
		this(employeeID,name,address,bankAccount);
		this.startSalary= startSalary;
	}
	
	
	public Employee(int employeeID, String name,String address,int bankAccount, float startSalary, String department){
		this(employeeID,name,address,bankAccount,startSalary);
		this.department =  department;
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
	public int getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(int bankAccount) {
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
	
	
	
}
