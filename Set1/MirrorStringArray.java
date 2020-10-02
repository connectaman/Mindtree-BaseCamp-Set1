package Set1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Problem No 17
public class MirrorStringArray {
	public static void main(String[] args)throws IOException {
		BufferedReader obj  = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the size of Array");
		int n = Integer.parseInt(obj.readLine());
		String[] str = new String[n];
		String[] rev = new String[n];
		System.out.println("Enter the array elements ");
		for(int i=0;i<n;i++) {
			str[i] = obj.readLine();
		}
		for(int i=0;i<n;i++) {
			rev[i] = reverseString(str[i]);
		}
		for(int i=0;i<n;i++) {
			System.out.println(str[i] + " : "+rev[i]);
		}
	}
	public static String reverseString(String s) {
		String rev = "";
		for(int i=s.length()-1;i>=0;i--) {
			rev+=s.charAt(i);
		}
		return rev;
	}

}
