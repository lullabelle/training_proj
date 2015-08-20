package employees;
import employees.Employee;

import java.util.Scanner;

public class EmployeeTesterClass {
	public static void main(String[] args) {
		
		Scanner keyIn = new Scanner(System.in);
	
	Employee emp1;
	try {
		emp1 = new Employee();
		
		System.out.println("Enter Employee Name");
		String n = keyIn.nextLine();
		emp1.setName(n);
		
		System.out.println("Enter Employee address");
		n = keyIn.nextLine();
		emp1.setAddress(n);
		
		System.out.println("Enter Employee starting Salary");
		int s = keyIn.nextInt();
		
		emp1.setStartSalary(s);
		
		System.out.println("Enter Employee Bank Account");
		 s = keyIn.nextInt();
		emp1.setBankAccount(s);
		
		System.out.println(emp1.getName());
		System.out.println(emp1.getAddress());
		System.out.println(emp1.getStartSalary());
		System.out.println(emp1.getBankAccount());
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.err.print(e.getCause());
	}
	

	
	}
	

}
