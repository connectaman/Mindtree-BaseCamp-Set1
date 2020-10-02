package Set1;
import java.util.Scanner;
//Problem No 4
public class FormCircularString {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = scan.next();
		System.out.println("Enter the rotation number");
		int n = scan.nextInt();
		if(str == null || n <= 0) {
			System.out.println("Sorry the Inputs are Incorrect");
		}else {
			int low = 0;
			for(int i=0;i<str.length();i++) {
				int j = 0;
				String rot = "";
				while(j<n) {
					if((i+j)>str.length()-1) {
						rot+=str.charAt((i+j)%n);
					}else {
						rot+=str.charAt((i+j));
					}
					j++;
				}
				System.out.println(rot);
			}	
		}
	}
}
