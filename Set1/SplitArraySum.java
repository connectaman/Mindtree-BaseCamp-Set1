package Set1;

import java.util.Scanner;

// Problem No 21
public class SplitArraySum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of the Array");
		int n = scan.nextInt();
		int[] arr = new int[n];
		boolean flag = false;
		if(n>1) {
			System.out.println("Enter the array elements");
			for(int i=0;i<n;i++) {
				arr[i]= scan.nextInt();
			}
			int sum1 = 0;
			for(int i=0;i<n;i++) {
				sum1+=arr[i];
				
				int sum2 = 0;
				
				for(int j=i+1;j<n;j++) {
					sum2+=arr[j];
				}
				
				if(sum1==sum2) {
					flag = true;
				}
			}
				System.out.println(flag?"True":"False");
		}else {
			System.out.println("Operation not Performable");
		}
		
	}

}
