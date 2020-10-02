package IntegratedPracticeProblem.Museum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// problem 2
public class Museum implements MuseumImpl {
	public static int visitors = 0;
	public static int total_amount = 0;
	public static MuseumBean[] visits = new MuseumBean[100];
	public static void main(String[] args)throws IOException {
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		boolean next = true;
		do {
			System.out.println("1 - Enter Visitor Details");
			System.out.println("2 - Fetch Number of Visitors Visited Today");
			System.out.println("3 - Fetch Number of Visitors within age range");
			System.out.println("4 - Fetch Male to Female Ratio");
			System.out.println("5 - Fetch Total Earning");
			System.out.println("6 - Exit");
			System.out.println("Enter your choice ");
			int choice = Integer.parseInt(obj.readLine());
			Museum m  = new Museum();
			switch(choice) {
			case 1:
				System.out.println("Enter Visitor Name ");
				String name = obj.readLine();
				System.out.println("Enter Visitor Age");
				int age = Integer.parseInt(obj.readLine());
				System.out.println("Enter Visitor Gender (male/female) ");
				String gender = obj.readLine();
				m.entry(name,age,gender);
			break;
			case 2:
				System.out.println("Total Number of Visitor Today : "+m.totalVisitors());
			break;
			case 3:
				System.out.println("Enter the age start range ");
				int start = Integer.parseInt(obj.readLine());
				System.out.println("Enter the age end range ");
				int end = Integer.parseInt(obj.readLine());
				System.out.println("Total Number of Visitor within age "+start+" to "+end+" is "+m.rangeAge(start,end));
			break;
			case 4:
				System.out.println("Ratio of Male:Female "+m.ratioMtoF());
			break;
			case 5:
				System.out.println("Total Earning "+m.totalEarning()+" Rs");
			break;
			case 6:
				next = false;
				break;
			default:
				next = false;
			}	
		}while(next);
	}
	@Override
	public void entry(String name, int age, String gender) {
		if(name.length()<1) {
			System.out.println("Invalid name");
			return;
		}
		if(age < 0 || age > 150) {
			System.out.println("Invalid Age");
			return;
		}
		if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
			int fee = calculateFee(age);
			visits[visitors] = new MuseumBean(name,age,gender);
			visitors++;
			System.out.println("Visitor Data added");
			System.out.println("Visitor Fee : "+fee);
		}else {
			System.out.println("invalid gender Input");
			return;
		}
	}
	@Override
	public String ratioMtoF() {
		String ratio = "";
		if(visitors<=0) {
			System.out.println("Sorry There are no visitors");
		}else {
			int male = 0;
			int female = 0;
			for(int i=0;i<visitors;i++) {
				if(visits[i].getGender().equalsIgnoreCase("male")){
					male++;
				}else {
					female++;
				}
			}
			ratio = String.valueOf(male) + "  : "+ String.valueOf(female)+" ";
		}
		return ratio;
	}
	@Override
	public int totalEarning() {
		return total_amount;
	}
	@Override
	public int rangeAge(int start, int end) {
		int range = 0;
		for(int i=0;i<visitors;i++) {
			if(visits[i].getAge()>=start && visits[i].getAge()<=end) {
				range++;
			}
		}
		return range;
	}
	@Override
	public int totalVisitors() {
		return visitors;
	}
	@Override
	public int calculateFee(int age) {
		int fee = 0;
		if(age>=5 && age<=18) {
			fee = 10;
		}else if(age>18 && age<=60) {
			fee = 20;
		}else if(age>60) {
			fee = 5;
		}else {
			fee = 0;
		}
		total_amount+=fee;
		return fee;
	}
}
