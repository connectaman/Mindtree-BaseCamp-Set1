package Set1;

import java.util.Scanner;

// Problem No 18
public class RecurrenceString {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = scan.next();
		System.out.println("Enter the recurrence number ");
		int n = scan.nextInt();
		String result = "";
		if(str.length()<3) {
			System.out.println("Operation Not Performable Since length is lesser than 3");
		}else {
			String three = "";
			for(int i=0;i<3;i++) {
				three+= str.charAt(i);
			}
			for(int i=0;i<n;i++) {
				result += three;
			}
		}
		System.out.println(result);
	}

}
