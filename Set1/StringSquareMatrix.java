package Set1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Problem No 5
public class StringSquareMatrix {

	public static void main(String[] args)throws IOException {
		int n = 0;
		boolean isNext = true;
		boolean isInput  = false;
		String[][] str = null;
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println("Enter your choice ");
			System.out.println("1 - Enter the size of matrix ");
			System.out.println("2 - Enter the string in matrix ");
			System.out.println("3 - Search a string in matrix ");
			System.out.println("4 - Exit ");
			int choice  = Integer.parseInt(obj.readLine());
			switch(choice) {
			case 1:
				System.out.println("Enter the size ");
				n = Integer.parseInt(obj.readLine());
			break;
			case 2:
				System.out.println("Enter the string in matrix ");
				str = new String[n][n];
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						str[i][j] = obj.readLine();
					}
				}
				isInput = true;
			break;
			case 3:
				if(str!=null && isInput==true) {
					System.out.println("Enter the string to be searched : ");
					String search = obj.readLine();
					System.out.println(isPresent(str,n,search)? "Present":"Not Present");
				}else {
					System.out.println("Please Enter the Size and Matrix first");
				}
			break;
			case 4:
				isNext = false;
			break;
			default:
				isNext = false;
			break;
			}
		}while(isNext);
	}
	public static boolean isPresent(String[][] str,int n,String search) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(str[i][j].equalsIgnoreCase(search)) {
					return true;
				}
			}
		}
		return false;
	}

}
