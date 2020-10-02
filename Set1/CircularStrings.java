package Set1;

import java.util.Scanner;

//Problem No 3
public class CircularStrings {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the String ");
		String str = scan.next();
		System.out.println("Enter the rotated String");
		String rot = scan.next();
		if(str.length()<=0 || rot.length()<=0) {
			System.out.println("Operation not Performable");
		}else {
			System.out.println(isCircular(str,rot)?"Circular":"Not Circular");
		}

	}
	public static boolean isCircular(String s1,String s2) {
		int s1_len = s1.length();
		int s2_len = s2.length();
		
		if(s1_len != s2_len) {
			return false;
		}
		String str = s1+s1;
		return str.indexOf(s2)!=-1;
	}

}
