package Set1;

import java.util.Scanner;

// Problem No 6
public class CalculateTaxEmployee {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float salary = 0;
		System.out.println("Enter the salary of employee");
		salary = scan.nextFloat();
		float tax = 0;
		if(salary <= 0) {
			System.out.println("Sorry The Salary is Invalid");	
		}else if(salary <= 50000) {
			tax = 0;
		}else if(salary <= 60000) {
			tax = (float) (salary * 0.10); 
		}else if(salary <= 150000) {
			tax = (float) (salary * 0.20); 
		}else{
			tax = (float) (salary * 0.30); 
		}
		System.out.println("Income Tax : "+tax+" Rs");
	}

}
