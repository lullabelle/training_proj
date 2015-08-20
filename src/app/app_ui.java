package app;

import java.util.Scanner;

public class app_ui {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		//variables
		int intMenuChoice = 0;
		int arrayIndex;
		
		//interface menu
		
		arrayIndex = 0;
		int intRecordCount = 0;
		
		do 
		{			
			System.out.println("=====================");	
			System.out.println("===== Main Menu =====");
			System.out.println("1. List all Employees ");
			System.out.println("2. List all Sales Employees");
			System.out.println("3. List all available employees for projects");
			System.out.println("4. ----");
			System.out.println("5. Exit");
			
			System.out.println("=====================");
		
				System.out.print(" Option - ");
				intMenuChoice = scan.nextInt();
				
				switch (intMenuChoice)
				{
				case 1:	
					
					break;		
				case 2: 		 														
								break;
								
				case 3: 		 		
								break;
								
				case 4: 					
								break;
				case 5: {
					System.out.println("End");
					System.exit(0);
				}
				default: {
					System.out.println("Invalid menu choice");
					
					break;
				}
				}
				
				
				
								

	

			}
		while (intMenuChoice != 6);
		scan.close();
}
}