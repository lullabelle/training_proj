package employees;

public class SalesEmployee extends Employee {
	
	
	private double commissionRate;
	private double salesRate;
	
	public SalesEmployee(int employeeID) {
		super(employeeID);
		// TODO Auto-generated constructor stub
	}
	
	public double getCommissionRate() {
		return commissionRate;
	}
	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}
	public double getSalesRate() {
		return salesRate;
	}
	public void setSalesRate(double salesRate) {
		this.salesRate = salesRate;
	}
	

}
