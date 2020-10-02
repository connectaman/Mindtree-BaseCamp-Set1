package Set1;
import java.util.Scanner;
// Problem No 24
public class SuperiorElementMatrix {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the row and col of matrix");
		int row = scan.nextInt();
		int col = scan.nextInt();
		int[][] arr = new int[row][col];
		if(row>1 && col>1) {
			System.out.println("Enter the Matrix");
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					arr[i][j] = scan.nextInt();
				}
			}
			int superior = arr[0][0];
			int s_one = 0,s_two = 0;
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					if(arr[i][j]>superior) {
						superior = arr[i][j];
						s_one = i;
						s_two = j;
					}
				}
			}
			System.out.println("Superior Element is Found is Index Position ("+s_one+","+s_two+")");
		}else {
			System.out.println("Operation not performable");
		}
	}

}
