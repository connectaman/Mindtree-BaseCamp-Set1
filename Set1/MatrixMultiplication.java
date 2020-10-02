package Set1;

import java.util.Scanner;

//Program No 13
public class MatrixMultiplication {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the row and col of Matrix 1");
		int row1 = scan.nextInt();
		int col1 = scan.nextInt();
		System.out.println("Enter the row and col of Matrix 2");
		int row2 = scan.nextInt();
		int col2 = scan.nextInt();
		if(row1<0 || col1<0 || row2<0 || col2<0) {
			System.out.println("Wrong Data Input");
		}else {
			int[][] a = new int[row1][col1];
			int[][] b = new int[row2][col2];
			System.out.println("Enter Matrix 1 of "+row1+" rows and "+col1+" cols");
			for(int i=0;i<row1;i++) {
				for(int j=0;j<col1;j++) {
					a[i][j] = scan.nextInt();
				}
			}	
			System.out.println("Enter Matrix 2 of "+row2+" rows and "+col2+" cols");
			for(int i=0;i<row2;i++) {
				for(int j=0;j<col2;j++) {
					b[i][j] = scan.nextInt();
				}
			}
			multipleMatrixAndPrint(a,b,row1,col1,row2,col2);
		}

	}
	public static void multipleMatrixAndPrint(int a[][],int b[][], int row1,int col1,int row2,int col2) {
		if(row2 != col1) {
			System.out.println("Cannot print Matrix Multiplication");
			return;
		}
		int sum[][] = new int[row1][col2];
		for(int i=0;i<row1;i++) {
			for(int j=0;j<col2;j++) {
				for(int k=0;k<row2;k++) {
					sum[i][j] += a[i][k] + b[k][j]; 
				}
			}
		}
		System.out.println("The Sum Matrix : ");
		for(int i=0;i<row1;i++) {
			for(int j=0;j<col2;j++) {
				System.out.print(sum[i][j]+" ");
			}
			System.out.println();
		}	
	}
}
