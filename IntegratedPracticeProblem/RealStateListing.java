package IntegratedPracticeProblem;
// problem No 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class RealState{
	private String type;
	private int bhk;
	private String flat;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getBhk() {
		return bhk;
	}
	public void setBhk(int bhk) {
		this.bhk = bhk;
	}
	public String getFlat() {
		return flat;
	}
	public void setFlat(String flat) {
		this.flat = flat;
	}
	public RealState(String type, int bhk, String flat) {
		super();
		this.type = type;
		this.bhk = bhk;
		this.flat = flat;
	}
	@Override
	public String toString() {
		return "RealState [type=" + type + ", bhk=" + bhk + ", flat=" + flat + "]";
	} 
}
public class RealStateListing {
	public static RealState[] real = new RealState[20];
	public static int index = 0;
	public static void main(String[] args)throws IOException {
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		boolean next = true;
		do {
			System.out.println("1- Enter a Real State Data");
			System.out.println("2- List RealState Based on Rent or Sale");
			System.out.println("3- List RealState Based on 1/2/3BHK");
			System.out.println("4- List based on Rent or Sale and then 1/2/3 BHK");
			System.out.println("5- Print All Listing");
			System.out.println("6- Exit");
			int choice = Integer.parseInt(obj.readLine());
			switch(choice) {
			case 1:
				System.out.println("Enter the RealState Type [Rent] if ToLet [Sale] if For Sale");
				String type = obj.readLine();
				System.out.println("Enter the BHK [Enter 1 or 2 or 3]");
				int bhk = Integer.parseInt(obj.readLine());
				System.out.println("Enter whether Flat or House  | [flat] or [house]");
				String flat = obj.readLine();
				if(type.equalsIgnoreCase("rent") || type.equalsIgnoreCase("sale") || (bhk>=1 && bhk <=3) || flat.equalsIgnoreCase("flat") || flat.equalsIgnoreCase("house")) {
					entry(type,bhk,flat);
				}else {
					System.out.println("Sorry Incorrect Input Please Enter [rent] or [sale]");
				}
			break;
			case 2:
				System.out.println("Enter listing type [rent/sale]");
				String list_type = obj.readLine();
				RealState[] result = rentOrSale(list_type);
				int count = 0;
				for(int i=0;i<result.length;i++) {
					if(result[i]!=null) {
						count++;
						System.out.println(result[i]);
					}
				}
				System.out.println("Total Listing : "+count);
			break;
			case 3:
				System.out.println("Enter listing type BHK [1/2/3]");
				int list_bhk = Integer.parseInt(obj.readLine());
				RealState[] result_bhk = listType(list_bhk);
				int count_bhk = 0;
				for(int i=0;i<result_bhk.length;i++) {
					if(result_bhk[i]!=null) {
					count_bhk++;
					System.out.println(result_bhk[i]);
					}
				}
				System.out.println("Total Listing : "+count_bhk);
			break;
			case 4:
				System.out.println("Enter listing type [rent/sale]");
				String first = obj.readLine();
				System.out.println("Enter listing type BHK [1/2/3]");
				int second = Integer.parseInt(obj.readLine());
				RealState[] first_list = listType(second);
				RealState[] second_list = rentOrSale(first_list,first);
				int count_two = 0;
				for(int i=0;i<second_list.length;i++) {
					if(second_list[i]!=null) {
					count_two++;
					System.out.println(second_list[i]);
					}
				}
				System.out.println("Total Listing : "+count_two);
			break;
			case 5:
				printAllList();
			break;
			case 6:
				next = false;
			break;
			default:
				next = false;
			}
		}while(next);

	}
	public static void entry(String type,int bhk,String flat) {
		boolean flag = false;
		if(type.equalsIgnoreCase("rent") || type.equalsIgnoreCase("sale")) {
			if(bhk > 0 && bhk <=3) {
				if(flat.equalsIgnoreCase("flat") || flat.equalsIgnoreCase("house")) {
					flag = true;
					real[index++] = new RealState(type,bhk,flat);
				}
			}
		}
		System.out.println(flag?"Data Added Success":"Invalid Inputs");
	}
	public static RealState[] listType(int bhk) {
		RealState[] sorted = new RealState[index];
		int j = 0;
		for(int i=0;i<index;i++) {
			if(real[i].getBhk()==bhk) {
				sorted[j++] = real[i];
			}
		}
		return sorted;
	}
	public static RealState[] rentOrSale(String type) {
		RealState[] sorted = new RealState[index];
		int j = 0;
		for(int i=0;i<index;i++) {
			if(real[i].getType().equalsIgnoreCase(type)) {
				sorted[j++] = real[i];
			}
		}
		return sorted;
	}
	public static RealState[] rentOrSale(RealState[] data,String type) {
		RealState[] sorted = new RealState[index];
		int j = 0;
		for(int i=0;i<data.length;i++) {
			if(data[i].getType().equalsIgnoreCase(type)) {
				sorted[j++] = real[i];
			}
		}
		return sorted;
	}
	public static void printAllList() {
		for(int i=0;i<index;i++) {
			System.out.println(real[i]);
		}
	}

}
