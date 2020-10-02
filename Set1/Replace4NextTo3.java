package Set1;

import java.util.Scanner;
//Problem No 22
public class Replace4NextTo3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n = scan.nextInt();
		int[] arr = new int[n];
		if(n>=2) {
			System.out.println("Enter the array elements");
			for(int i=0;i<n;i++) {
				arr[i] = scan.nextInt();
			}
			int three = -1;
			int four = 0;
			for(int i=0;i<n;i++) {
				if(arr[i]==3) {
					three = i;
					for(int j=four;j<n;j++) {
						if(arr[j]==4) {
							int temp = arr[three+1];
							arr[three+1] = 4;
							arr[j] = temp;
							four = j;
							break;
						}
					}
				}
			}
			for(int i=0;i<n;i++) {
				System.out.print(arr[i]+" ");
			}
		}else {
			System.out.println("Operation not Performable");
		}

	}

}
