package Set1;
import java.util.Scanner;
// Problem 20
public class AddLeftMostRightMost {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of Array");
		int n = scan.nextInt();
		if(n<=2) {
			System.out.println("The size cannot be less than 2");
		}else {
			System.out.println("Enter the array elements ");
			int[] elem = new int[n];
			for(int i=0;i<n;i++) {
				elem[i] = scan.nextInt();
			}
			int sum = 0;
			for(int i=1;i<n-1;i++) {
				sum+=elem[i];
			}
			System.out.println("Sum = "+sum);
		}
	}
}
