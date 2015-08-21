package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import employees.Employee;

public class app_ui {

	public static void main(String[] args) {

		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		Employee emp = new Employee();

		// variables

		int intMenuChoice = 0;

		String tempName;
		String tempAddress;
		String tempNINO;
		String tempBank;
		Float tempSalary;
		String tempDept;
		

		// interface menu


		do {
			System.out.println("=====================");
			System.out.println("===== Main Menu =====");
			System.out.println("1. List all Employees ");
			System.out.println("2. List all Sales Employees");
			System.out.println("3. List all available employees for projects");
			System.out.println("4. Enter a new employee");
			System.out.println("5. Exit");

			System.out.println("=====================");

			System.out.print(" Option - ");
			try{
			intMenuChoice = Integer.parseInt(reader.readLine());

			switch (intMenuChoice) {
			case 1:
				emp.SelectEmployees();
				break;
			case 2:
				emp.SelectSalesEmployees();
				break;

			case 3:
				emp.SelectsAvailableEmployees();
				break;

			case 4:
				System.out.print("Name: ");
				tempName = reader.readLine();

				System.out.print("Address: ");
				tempAddress = reader.readLine();
				System.out.print("Enter National Insurance: ");
				tempNINO = reader.readLine();
				System.out.print("Bank account number: ");
				tempBank = reader.readLine();
				System.out.print("Starting Salary: ");
				tempSalary = Float.parseFloat(reader.readLine());
				System.out.print("Enter department: ");
				tempDept = reader.readLine();

				
				Employee tmp = new Employee(tempName, tempAddress, tempNINO, tempBank, tempSalary, tempDept);
				
				emp.addEmployee(tmp);
				
				
				break;
			case 5: 
				System.out.println("End");
				System.exit(0);
			
			default: 
				System.out.println("Invalid menu choice");

				break;
			
			}
			}catch(Exception ex){
				System.out.println("Application error: " + ex.getMessage());
			}
		} while (intMenuChoice != 6);
		
		
	}

		
	}




