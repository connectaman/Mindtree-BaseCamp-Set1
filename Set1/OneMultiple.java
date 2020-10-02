package Set1;

import java.util.Scanner;

// Problem No 9
public class OneMultiple {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter n value range 0<n<10000");
		int n = scan.nextInt();
		boolean flag = false;
		for(int i=2;i<=10;i++) {
			if(i%2!=0 && i%5!=0) {
				int count = ones(n*i); 
				if(count != -1) {
					System.out.println(count);
					flag = true;
				}
			}
		}
		if(!flag) {
			System.out.println("No such multiple");
		}

	}
	public static int ones(int decimal){    
	     int binary[] = new int[40];    
	     int index = 0;  
	     int count = 0;
	     String b = "";
	     while(decimal > 0){    
	       binary[index++] = decimal%2;    
	       decimal = decimal/2;    
	     }    
	     for(int i = index-1;i >= 0;i--){    
	    	 b = b + String.valueOf(binary[i]);
	     }
//	     System.out.println(b);
	     for(int i=0;i<b.length();i++) {
	    	 if(b.charAt(i)!='1') {
	    		 return -1;
	    	 }
	    	 count++;
	     }
//	     System.out.println(count);
	     return count;
	}

}
