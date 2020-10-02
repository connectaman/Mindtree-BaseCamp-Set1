package Set1;

import java.util.Scanner;

// Problem No 14
public class VowelOccurance {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] vowels = {'a','e','i','o','u'};
		int[] freq = new int[5];
		System.out.println("Enter the sentence in lower case : ");
		String str = scan.nextLine();
		if(str.length()<=0) {
			System.out.println("Sorry Invalid Input");
		}else {
			for(int i=0;i<str.length();i++) {
				char ch = str.charAt(i);
				if(ch!=' ') {
					for(int j=0;j<vowels.length;j++) {
						if(ch == vowels[j]) {
							freq[j] +=1;
						}
					}
				}
			}
			for(int i=0;i<5;i++) {
				System.out.println(vowels[i]+" : "+freq[i]);
			}	
		}
	}
}
