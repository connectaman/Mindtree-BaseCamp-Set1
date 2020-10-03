package IntegratedPracticeProblem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Problem No 9
class Plan{
	private String name;
	private int speed;
	private int download;
	private int price;
	public Plan(String name, int speed, int download, int price) {
		this.name = name;
		this.speed = speed;
		this.download = download;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDownload() {
		return download;
	}
	public void setDownload(int download) {
		this.download = download;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Plan [name=" + name + ", speed=" + speed + ", download=" + download + ", price=" + price + "]";
	}
}
class User{
	private String name;
	private int id;
	private String phone;
	private String address;
	private String plan;
	public User(String name, int id, String phone, String address, String plan) {
		this.name = name;
		this.id = id;
		this.phone = phone;
		this.address = address;
		this.plan = plan;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", phone=" + phone + ", address=" + address + ", plan=" + plan
				+ "]";
	}
}
public class InternetProvider {
	public static User[] user = new User[10];
	public static Plan[] plan = new Plan[10];
	public static int user_index = 0;
	public static int plan_index = 0;
	public static void main(String[] args)throws IOException {
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		boolean next = true;
		do {
			System.out.println("1 - Add User");
			System.out.println("2 - Add Plan");
			System.out.println("3 - Display All Users");
			System.out.println("4 - Display All Plan ");
			System.out.println("5 - Display User Subscribed to a Plan");
			System.out.println("6 - Display City Name in Reverse");
			System.out.println("7 - Sort Plan in Ascending Order");
			System.out.println("8 - Exit");
			int choice = Integer.parseInt(obj.readLine());
			switch(choice) {
			case 1:
				if(plan_index<=0) {
					System.out.println("Please Enter Plan First");
					break;
				}
				System.out.println("Enter User Name");
				String uname = obj.readLine();
				if(uname.length()<=0) {
					System.out.println("Invalid Name");
					break;
				}
				System.out.println("Enter user id ");
				int uid = Integer.parseInt(obj.readLine());
				if(isUserPresent(uid)) {
					System.out.println("user Id already present");
					break;
				}
				if(uid<=0) {
					System.out.println("Invalid Uid");
					break;
				}
				System.out.println("Enter User Phone");
				String phone = obj.readLine();
				if(phone.length()!=10) {
					System.out.println("Phone Invalid");
					break;
				}
				System.out.println("Enter User Address");
				String add = obj.readLine();
				if(add.length()<=0) {
					System.out.println("Invalid Address");
					break;
				}
				System.out.println("Enter User Plan");
				String uplan = obj.readLine();
				if(isPlanPresent(uplan)) {
					user[user_index++] = new User(uname,uid,phone,add,uplan);
				}else {
					System.out.println("The plan entered is not available");
				}
			break;
			case 2:
				System.out.println("Enter Plan Name");
				String plan_name = obj.readLine();
				if(isPlanPresent(plan_name)) {
					System.out.println("Plan Alread Exist");
				}else {
					if(plan_name.length()<=0) {
						System.out.println("Invaid Plan Name");
						break;
					}
				}
				System.out.println("Enter Internet Speed");
				int speed = Integer.parseInt(obj.readLine());
				if(speed<=0) {
					System.out.println("Invalid Speed");
					break;
				}
				System.out.println("Enter download Limit");
				int limit = Integer.parseInt(obj.readLine());
				if(limit <=0) {
					System.out.println("Invalid Limit");
					break;
				}
				System.out.println("Enter the price of Plan");
				int price = Integer.parseInt(obj.readLine());
				if(price<=0) {
					System.out.println("Invalid Price");
					break;
				}
				plan[plan_index++] = new Plan(plan_name,speed,limit,price);
			break;
			case 3:
				displayAllUser();
			break;
			case 4:
				displayAllPlan();
			break;
			case 5:
				System.out.println("Enter the Plan to Search the users");
				String search_plan = obj.readLine();
				if(isPlanPresent(search_plan)) {
					displayUserAsPerPlan(search_plan);
				}else {
					System.out.println("The plan you entered is not there in the list");
				}
			break;
			case 6:
				displayAllUserReverseAddress();
			break;
			case 7:
				Plan[] sorted = sortPlanInAscendingOrder();
				System.out.println("Plan in Sorted Order on Price");
				for(int i=0;i<sorted.length;i++) {
					System.out.println(sorted[i]);
				}
			break;
			default:
				next  = false;
			}
		}while(next);

	}
	public static void displayAllUser() {
		if(user_index>0) {
			for(int i=0;i<user_index;i++) {
				System.out.println(user[i]);
			}
		}else {
			System.out.println("No user data available");
		}
	}
	public static void displayAllPlan() {
		if(plan_index>0) {
			for(int i=0;i<plan_index;i++) {
				System.out.println(plan[i]);
				}
		}else {
			System.out.println("No Plan Available");
		}
	}
	public static void displayUserAsPerPlan(String plan) {
		if(user_index>0) {
			for(int i=0;i<user_index;i++) {
				if(user[i].getPlan().equalsIgnoreCase(plan)) {
					System.out.println(user[i]);
				}
			}
		}else {
			System.out.println("No user data available");
		}
	}
	public static void displayAllUserReverseAddress() {
		if(user_index>0) {
			for(int i=0;i<user_index;i++) {
				System.out.println(reverseAddress(user[i].getAddress()));
			}
		}else {
			System.out.println("No user data available");
		}
	}
	public static String reverseAddress(String add) {
		String rev = "";
		for(int i=add.length()-1;i>=0;i--) {
			rev+=add.charAt(i);
		}
		return rev;
	}
	public static Plan[] sortPlanInAscendingOrder() {
		Plan[] sort = new Plan[plan_index];
		for(int i=0;i<plan_index;i++) {
			sort[i] = plan[i];
		}
		for(int i=0;i<plan_index;i++) {
			for(int j=0;j<plan_index-1;j++) {
				if(sort[j].getPrice() > sort[j+1].getPrice()) {
					Plan temp = sort[j];
					sort[j] = sort[j+1];
					sort[j+1] = temp;
				}
			}
		}
		return sort;
	}
	public static boolean isPlanPresent(String p) {
		for(int i=0;i<plan_index;i++) {
			if(plan[i].getName().equalsIgnoreCase(p)) {
				return true;
			}
		}
		return false;
	}
	public static boolean isUserPresent(int uid) {
		for(int i=0;i<user_index;i++) {
			if(user[i].getId() == uid) {
				return true;
			}
		}
		return false;
	}

}
