package Set1;

import java.util.Scanner;

// Problem No. 11
public class AngleBtwHourMin {
	//Formula
	// H*(360/12) + (M*360)/(12*60)
	// M*(360/60)
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter time in HH:MM format ");
		String time = scan.next();
		if(time.length()< 5 || time.length() > 5) {
			System.out.println("Sorry Invalid Input format pls enter in HH:MM format");
		}else {
			int i = 0;
			String hour = "";
			while(time.charAt(i)!=':'){
				hour+=time.charAt(i);
				i++;
			}
			i++;
			String min = "";
			while(i<time.length()) {
				min+=time.charAt(i);
				i++;
			}
			System.out.println(getAngle(Integer.valueOf(hour),Integer.valueOf(min)));
		}
	}
	public static int getAngle(int h, int m) 
	    { 
	        if (h <0 || m < 0 || h >12 || m > 60) 
	            System.out.println("Wrong input"); 
	        if (h == 12) 
	            h = 0; 
	        if (m == 60)  {
	        	m = 0;
	        	h++;
	        }
	        int hour_angle = (int)(0.5 * (h*60 + m)); 
	        int minute_angle = (int)(6*m); 
	        int angle = Math.abs(hour_angle - minute_angle); 
	        angle = Math.min(360-angle, angle); 
	        return angle; 
	    } 
}
