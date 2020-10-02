package Set1;

import java.util.Scanner;
// Problem No. 10
public class UniqueCharacters {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a string/sentence (in lowercase)");
		String str = scan.nextLine();
		System.out.println(isUnique(str)? "the String is Unique":"The String is not Unique");
	}
	public static boolean isUnique(String s) {
		int[] freq = new int[26];
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(ch!=' ' && (ch>='a'&&ch<='z')) {
				freq[(int)(ch - 'a')] += 1;	
			}
		}
		for(int i=0;i<26;i++) {
			if(freq[i]>1) {
				return false;
			}
		}
		return true;
	}
}
