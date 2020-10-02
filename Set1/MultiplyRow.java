package Set1;
import java.util.Scanner;
// Problem No 15
public class MultiplyRow {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the row and col of Matrix");
		int row = scan.nextInt();
		int col = scan.nextInt();
		System.out.println("Enter the matrix");
		int[][] a = new int[row][col];
		int[][] b = new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				a[i][j] = scan.nextInt();
			}
		}
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(i!=row-1) {
					b[i][j] = a[i][j] * a[i+1][j]; 
				}else {
					b[i][j] = a[i][j] * a[0][j]; 
				}
			}
		}
		System.out.println("Matrix after Multiplication : ");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
	}

}
