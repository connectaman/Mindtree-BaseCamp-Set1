package Set1;

import java.util.Scanner;

public class EmailPercentage {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Email Address");
		String email = scan.nextLine();
		int upper = 0;
		int lower = 0;
		int digit = 0;
		int n = email.length()-1;
		boolean flag = false;
		for(int i=0;i<=n;i++) {
			char ch = email.charAt(i);
			if(ch==' ') {
				flag = false;
				break;
			}
			if(ch>='A' && ch<='Z') {
				upper++;
			}else if(ch>='a' && ch<='z') {
				lower++;
			}else if(ch>='0' && ch<='9') {
				digit++;
			}else {
				continue;
			}
		}
		System.out.println("% of UpperCase Letter : "+(float)(upper*100)/n+"%");
		System.out.println("% of LowerCase Letter : "+(float)(lower*100)/n+"%");
		System.out.println("% of Digits Letter : "+(float)(digit*100)/n+"%");
	}
}
