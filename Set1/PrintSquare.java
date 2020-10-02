package Set1;

import java.util.Scanner;

// problem Number 7
public class PrintSquare {
	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		System.out.println("Enter the n value to generate square of natural number ");
		int n = scan.nextInt();
		try {
			for(int i=1;i<=n;i++) {
				printSquareNumber(i);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void printSquareNumber(int n) {
		int square = n*n;
		if(square > 100) {
			throw new RuntimeException("The Square exceeds the limit 100 !! ");
		}else {
			System.out.println(square);
		}
	}

}
