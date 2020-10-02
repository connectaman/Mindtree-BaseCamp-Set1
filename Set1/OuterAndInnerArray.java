package Set1;

import java.util.Scanner;

// Problem No 23
public class OuterAndInnerArray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of Outer Array");
		int outer_n = scan.nextInt();
		System.out.println("Enter the size of Inner Array");
		int inner_n = scan.nextInt();
		int[] outer = new int[outer_n];
		int[] inner = new int[inner_n];
		if(outer_n > 1 && inner_n > 1) {
			System.out.println("Enter the Outer Array");
			for(int i=0;i<outer_n;i++) {
				outer[i] = scan.nextInt();
			}
			System.out.println("Enter the Inner Array");
			for(int i=0;i<inner_n;i++) {
				inner[i] = scan.nextInt();
			}
			int j = 0;
			boolean flag = false;
			for(int i=0;i<outer_n;i++) {
				if(outer[i]==inner[j]) {
					j++;
				}
				if(j==inner_n-1) {
					break;
				}
			}
			System.out.println((j==(inner_n-1))?"True":"False");
		}else {
			System.out.println("Operation Not Performable");
		}

	}

}
