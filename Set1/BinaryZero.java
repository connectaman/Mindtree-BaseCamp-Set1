package Set1;

import java.util.Scanner;
// Problem No. 8
public class BinaryZero {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Decimal Number ");
		int n = scan.nextInt();
		if(n> 0) {
			int zeros = binaryZeros(n);
			System.out.println("Number of zeros = "+zeros);
		}else {
			System.out.println("Sorry the Number Entered is Not Correct ");
		}
	}
	public static int binaryZeros(int n) {
		int zeroCount = 0;
		while(n!=0) {
			int rem = n%2;
			if(rem == 0) {
				zeroCount++;
			}
			n/=2;
		}
		return zeroCount;
	}

}
