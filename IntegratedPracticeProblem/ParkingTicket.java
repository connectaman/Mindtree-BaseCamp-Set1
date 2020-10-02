package IntegratedPracticeProblem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// problem No 1
public class ParkingTicket {
	public final static int slots = 100;
	public static int available = 0;
	public static int exitSlot = 0;
	public static String[] vehicle = new String[slots];
	public static String[] timeEntry = new String[slots];
	public static void main(String[] args)throws IOException {
		BufferedReader obj  = new BufferedReader(new InputStreamReader(System.in));
		boolean next = true;
		do {
			System.out.println("1 - Check for the Slots Available");
			System.out.println("2 - Enter Vehicle in Slot");
			System.out.println("3 - Exit of Vehicle");
			System.out.println("4 - Exit");
			System.out.println("Enter your choice");
			int choice = Integer.parseInt(obj.readLine());
			switch(choice) {
			case 1:
				if(isSlotAvailable()) {
					System.out.println("Yes We do have Slots Available");
					System.out.println("Slots Available : "+(slots-available-exitSlot));
				}else {
					System.out.println("Sorry the slots are full");
				}
			break;
			case 2:
				System.out.println("Enter the Vehicle No.");
				String vehicleNo = obj.readLine();
				System.out.println("Enter the entry Time in HH:MM format");
				String time = obj.readLine();
				if(!isVehicleParked(vehicleNo) && isSlotAvailable() && (vehicleNo.indexOf(' ')==-1)) {
					boolean res = addVehicleParking(vehicleNo,time);
				}
			break;
			case 3:
				System.out.println("Enter the Vehicle number");
				String vehicleNoExit = obj.readLine();
				if(isVehicleParked(vehicleNoExit)) {
					System.out.println("Enter the Exit Time in HH:MM format");
					String exitTime = obj.readLine();
					String entryTime = getVehicleEntryTime(vehicleNoExit);
					if(entryTime!=null) {
						float fee = calculateFee(entryTime,exitTime);
						System.out.println("The Fee of "+vehicleNoExit+" is "+fee);
						exitSlot++;
					}
				}else {
					System.out.println("Sorry the vehicle is not Parked");
				}
			break;
			case 4:
				next = false;
			break;
			default:
				next = false;
			}
		}while(next);
	}
	public static boolean isVehicleParked(String vehicleNo) {
		for(int i=0;i<available;i++) {
			if(vehicle[i].equalsIgnoreCase(vehicleNo)) {
				return true;
			}
		}
		return false;
	}
	public static String getVehicleEntryTime(String vehicleNo) {
		for(int i=0;i<available;i++) {
			if(vehicle[i].equalsIgnoreCase(vehicleNo)) {
				return timeEntry[i];
			}
		}
		return null;
	}
	public static boolean isSlotAvailable() {
		return (available<=slots)? true:false;
	}
	public static boolean addVehicleParking(String vehicleNo,String time) {
		if(isSlotAvailable()) {
			boolean isAlreadyParked = isVehicleParked(vehicleNo);
			if(isAlreadyParked) {
				return false;
			}
			vehicle[available] = vehicleNo;
			timeEntry[available] = time;
			available++;
			return true;
		}
		return false;
	}
	public static float calculateFee(String entry,String exit) {
		float fee = 0;
		String hour1 = "";
		int i=0;
		while(entry.charAt(i)!=':'){
			hour1+=entry.charAt(i);
			i++;
		}
		i++;
		String min1 = "";
		while(i<entry.length()) {
			min1+=entry.charAt(i);
			i++;
		} 
		int time1 = Integer.parseInt(hour1+min1);
		String hour2 = "";
		i=0;
		while(entry.charAt(i)!=':'){
			hour2+=exit.charAt(i);
			i++;
		}
		i++;
		String min2 = "";
		while(i<entry.length()) {
			min2+=exit.charAt(i);
			i++;
		} 
		int time2 = Integer.parseInt(hour2+min2);
	    int hourDiff = time2 / 100 - time1 / 100 - 1; 
	    int minDiff = time2 % 100 + (60 - time1 % 100); 
	    if (minDiff >= 60) { 
	        hourDiff++; 
	        minDiff = minDiff - 60; 
	    } 
	    fee = 50 + (30*(hourDiff-2));
		return fee;
	}
	public static boolean clearVehicleSlot() {
		return false;
	}

}
