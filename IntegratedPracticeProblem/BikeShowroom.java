package IntegratedPracticeProblem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Problem No 8
class Bike{
	private String make;
	private String model;
	private String type;
	private int cc;
	private int price;
	public Bike(String make, String model, String type, int cc, int price) {
		this.make = make;
		this.model = model;
		this.type = type;
		this.cc = cc;
		this.price = price;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Bike [make=" + make + ", model=" + model + ", type=" + type + ", cc=" + cc + ", price=" + price + "]";
	}
}
public class BikeShowroom {
	public static Bike[] bike = new Bike[10];
	public static int bike_index = 0;
	public static void main(String[] args)throws IOException {
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));	
		boolean next = true;
		do {
			System.out.println("1 - Enter new Bike");
			System.out.println("2 - Display the Bikes Sorted in Make");
			System.out.println("3 - Display the Bike Sorted on Type and then Make");
			System.out.println("4 - Least and Most Expensive Bike");
			System.out.println("5 - Exit");
			int choice = Integer.parseInt(obj.readLine());
			switch(choice) {
			case 1:
				System.out.println("Enter The Bike Maker");
				String make = obj.readLine();
				System.out.println("Enter the Bike Model");
				String model = obj.readLine();
				System.out.println("Enter Bike type (Standard|Street|Sport|Touring|Sport Touring|Cruiser)");
				String type = obj.readLine();
				System.out.println("Enter the Bike CC");
				int cc =  Integer.parseInt(obj.readLine());
				System.out.println("Enter the price of Bike");
				int price =  Integer.parseInt(obj.readLine());
				if(price>0 && cc >=100) {
					bike[bike_index++] = new Bike(make,model,type,cc,price);
				}else {
					System.out.println("Invalid Data added");
				}
			break;
			case 2:
				Bike[] sorted_make = sortBikeOnMake();
				System.out.println("Bikes Sorted in Make : ");
				for(int i=0;i<sorted_make.length;i++) {
					System.out.println(sorted_make[i]);
				}
			break;
			case 3:
				System.out.println("Bikes Sorted in Type First");
				Bike[] sorted_type = sortBikeOnType();
				for(int i=0;i<sorted_type.length;i++) {
					System.out.println(sorted_type[i]);
				}
				System.out.println("Now Sorting the above Bike Based on Make ");
				Bike[] sort_make = sortBikeOnMake(sorted_type);
				for(int i=0;i<sort_make.length;i++) {
					System.out.println(sort_make[i]);
				}
			break;
			case 4:
				Bike least = leastExpensiveBike();
				Bike most = mostExpensiveBike();
				System.out.println("The Least Expensive Bike : ");
				System.out.println(least);
				System.out.println("The Most Expensive Bike : ");
				System.out.println(most);
			break;
			default:
				next  = false;
			}
			
		}while(next);
	}
	public static Bike[] sortBikeOnMake() {
		Bike[] sorted = new Bike[bike_index];
		for(int i=0;i<bike_index;i++) {
			sorted[i] = bike[i];
		}
		for(int i=0;i<bike_index;i++) {
			for(int j=0;j<bike_index-1;j++) {
				if(sorted[j].getMake().compareTo(sorted[j+1].getMake())>0) {
					Bike temp = sorted[j];
					sorted[j] = sorted[j+1];
					sorted[j+1] = temp;
				}
			}
		}
		return sorted;
	}
	public static Bike[] sortBikeOnMake(Bike[] data) {
		Bike[] sorted = new Bike[data.length];
		for(int i=0;i<data.length;i++) {
			sorted[i] = data[i];
		}
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data.length-1;j++) {
				if(sorted[j].getMake().compareTo(sorted[j+1].getMake())>0) {
					Bike temp = sorted[j];
					sorted[j] = sorted[j+1];
					sorted[j+1] = temp;
				}
			}
		}
		return sorted;
	}
	public static Bike[] sortBikeOnType() {
		Bike[] sorted = new Bike[bike_index];
		for(int i=0;i<bike_index;i++) {
			sorted[i] = bike[i];
		}
		for(int i=0;i<bike_index;i++) {
			for(int j=0;j<bike_index-1;j++) {
				if(sorted[j].getType().compareTo(sorted[j+1].getType())>0) {
					Bike temp = sorted[j];
					sorted[j] = sorted[j+1];
					sorted[j+1] = temp;
				}
			}
		}
		return sorted;
	}
	public static Bike mostExpensiveBike() {
		int max_price = bike[0].getPrice();
		int max_pos = 0;
		for(int i=0;i<bike_index;i++) {
			if(bike[i].getPrice()>max_price) {
				max_price = bike[i].getPrice();
				max_pos = i;
			}
		}
		return bike[max_pos];
	}
	public static Bike leastExpensiveBike() {
		int max_price = bike[0].getPrice();
		int max_pos = 0;
		for(int i=0;i<bike_index;i++) {
			if(bike[i].getPrice()<max_price) {
				max_price = bike[i].getPrice();
				max_pos = i;
			}
		}
		return bike[max_pos];
	}
}
