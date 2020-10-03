package IntegratedPracticeProblem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Problem No 11
class Customer{
	private int id;
	private String name;
	private String gender;
	private String service;
	private int cost;
	private int time;
	public Customer(int id, String name, String gender, String service, int cost, int time) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.service = service;
		this.cost = cost;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", gender=" + gender + ", service=" + service + ", cost="
				+ cost + ", time=" + time + "]";
	}
}
public class TheABCSaloon {
	public static Customer[] customer = new Customer[10];
	public static int index = 0;
	public static void main(String[] args)throws IOException {
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		boolean next = true;
		do {
			System.out.println("1 - Add Customer");
			System.out.println("2 - Display Customer with highest Service Time");
			System.out.println("3 - Display All Customer Sorted by ID");
			System.out.println("4 - Display All Service more than Cost");
			System.out.println("5 - Exit");
			int choice = Integer.parseInt(obj.readLine());
			switch(choice) {
			case 1:
				System.out.println("Enter Customer Id");
				int id = Integer.parseInt(obj.readLine());
				if(checkCustomerId(id)) {
					System.out.println("Customer Id Already Present");
					break;
				}
				System.out.println("Enter Customer Name");
				String name = obj.readLine();
				if(name.length()<=0) {
					System.out.println("Invalid Name");
					break;
				}
				System.out.println("Enter Customer Gender");
				String gender = obj.readLine();
				if(gender.length()<=0) {
					System.out.println("Invalid Gender");
					break;
				}
				System.out.println("Enter the service Type [Hair Style | Trim | Hair Cut | Manicure]");
				String service = obj.readLine();
				if(service.length()<=0) {
					System.out.println("Invalid Service");
					break;
				}
				System.out.println("Enter Service Cost");
				int cahrge = Integer.parseInt(obj.readLine());
				if(cahrge<=0) {
					System.out.println("Invalid Cost");
					break;
				}
				System.out.println("Enter the Service Time in Min Only");
				int time =  Integer.parseInt(obj.readLine());
				if(time<=0) {
					System.out.println("Invalid Time");
					break;
				}
				customer[index++] = new Customer(id,name,gender,service,cahrge,time);
			break;
			case 2:
				Customer high = highestTimeService();
				System.out.println(high);
			break;
			case 3:
				Customer[] sort = sortedCustomerById();
				for(int i=0;i<sort.length;i++) {
					System.out.println(sort[i]);
				}
			break;
			case 4:
				System.out.println("Enter the cost of Service");
				int cost = Integer.parseInt(obj.readLine());
				displayServiceByCost(cost);
			break;
			default:
				next = false;
			}
		}while(next);
	}
	public static Customer highestTimeService() {
		int max = customer[0].getTime();
		int max_pos = 0;
		for(int i=0;i<index;i++) {
			if(max < customer[i].getTime()) {
				max = customer[i].getTime();
				max_pos = i;
			}
		}
		return customer[max_pos];
	}
	public static Customer[] sortedCustomerById() {
		Customer[] sort = new Customer[index];
		for(int i=0;i<index;i++) {
			sort[i] = customer[i];
		}
		for(int i=0;i<index;i++) {
			for(int j=0;j<index-1;j++) {
				if(sort[j].getId() > sort[j+1].getId()) {
					Customer temp = sort[j];
					sort[j] = sort[j+1];
					sort[j+1] = temp;
				}
			}
		}
		return sort;
	}
	public static void displayServiceByCost(int cost) {
		for(int i=0;i<index;i++) {
			if(customer[i].getCost() >= cost) {
				System.out.println(customer[i]);
			}
		}
	}
	public static boolean checkCustomerId(int id) {
		for(int i=0;i<index;i++) {
			if(customer[i].getId() == id) {
				return true;
			}
		}
		return false;
	}
}
