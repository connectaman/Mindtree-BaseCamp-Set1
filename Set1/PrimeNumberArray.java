package Set1;

import java.util.Scanner;

//Program No 16
public class PrimeNumberArray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int n = scan.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter the elements of the array ");
		for(int i=0;i<n;i++) {
			arr[i] = scan.nextInt();
		}
		int[] primes = new int[n];
		int p_i = 0;
		for(int i=0;i<n;i++) {
			if(isPrime(arr[i])) {
				primes[p_i++] = arr[i];
			}
		}
		System.out.println("The prime numbers in array are : ");
		for(int i=0;i<n;i++) {
			if(primes[i]!=0) {
				System.out.println(primes[i]);
			}
		}
	}
	public static boolean isPrime(int n) {
		for(int i=2;i<=(n/2);i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}

}
