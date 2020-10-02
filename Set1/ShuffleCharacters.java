package Set1;

import java.util.Scanner;
//Problem No 1
public class ShuffleCharacters {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a string to shuffle ");
		String str = scan.nextLine();
		String shuffle_str = "";
		int n = str.length();
		int last_index = n-1;
		int start_index = 0;
		//Check Neg cases
		boolean isNeg = false;
		for(int i=0;i<n;i++) {
			char neg = str.charAt(i);
			if(neg>='a' && neg<='z') {
				isNeg = true;
			}else if(neg>='A' && neg<='Z') {
				isNeg = true;
			}else {
				isNeg = false;
				break;
			}
		}
		if(isNeg) {
			for(int i=0;i<n;i++) {
				if(i%2==0) {
					if(str.charAt(start_index)>='A' && str.charAt(start_index)<='Z') {
						shuffle_str+= (char)(str.charAt(start_index) + 32);
					}else {
						shuffle_str+=str.charAt(start_index);
					}
					start_index++;
				}else {
					if(str.charAt(last_index)>='A' && str.charAt(last_index)<='Z') {
						shuffle_str+=str.charAt(last_index);
					}else {
						shuffle_str+= (char)(str.charAt(last_index) - 32);
					}
					last_index--;
				}
				
			}
			System.out.println(shuffle_str);
		}else {
			System.out.println("No Result as the Input Doesn't match criteria");
		}
	}

}
