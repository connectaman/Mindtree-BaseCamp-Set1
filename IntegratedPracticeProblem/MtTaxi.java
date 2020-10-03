package IntegratedPracticeProblem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// Problem No 6
class Taxi{
	private int num;
	private String name;
	private int id;
	private int dis;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public int getDis() {
		return dis;
	}
	public void setDis(int dis) {
		this.dis = dis;
	}
	@Override
	public String toString() {
		return "Taxi [num=" + num + ", name=" + name + ", id=" + id + ", dis=" + dis + "]";
	}
	public Taxi(int num, String name, int id, int dis) {
		this.num = num;
		this.name = name;
		this.id = id;
		this.dis = dis;
	}
}
class TaxiUser{
	private String name;
	private int age;
	private String gender;
	private String phone;
	private int dis;
	public TaxiUser(String name, int age, String gender, String phone, int dis) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.dis = dis;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getDis() {
		return dis;
	}
	public void setDis(int dis) {
		this.dis = dis;
	}
	@Override
	public String toString() {
		return "TaxiUser [name=" + name + ", age=" + age + ", gender=" + gender + ", phone=" + phone + ", dis=" + dis
				+ "]";
	}
}
public class MtTaxi {
	public static Taxi[] taxi = new Taxi[10];
	public static int taxi_index = 0;
	public static TaxiUser[] user = new TaxiUser[10];
	public static int user_index = 0;
	public static void main(String[] args)throws IOException {
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		boolean next = true;
		do {
			System.out.println("1- Enter a Taxi ");
			System.out.println("2- Book Taxi For a User");
			System.out.println("3- Exit");
			int choice = Integer.parseInt(obj.readLine());
			switch(choice) {
			case 1:
				System.out.println("Enter Taxi Number");
				int num = Integer.parseInt(obj.readLine());
				if(isTaxiNumPresent(num)) {
					System.out.println("Taxi Number Already Present");
				}else {
					System.out.println("Enter Driver name");
					String name = obj.readLine();
					System.out.println("Enter Driver ID");
					int id =  Integer.parseInt(obj.readLine());
					if(isDriverIdPresent(id)) {
						System.out.println("Driver Id Already Entered");
					}else {
						System.out.println("Enter Distance of Taxi from Point");
						int dis =  Integer.parseInt(obj.readLine());
						addTaxi(num,name,id,dis);
					}
				}
			break;
			case 2:
				if(taxi_index<=0) {
					System.out.println("Enter User Name");
					String uname = obj.readLine();
					System.out.println("Enter User Age");
					int age = Integer.parseInt(obj.readLine());
					System.out.println("Enter User Gender");
					String gender = obj.readLine();
					System.out.println("Enter User Mobile");
					String phone = obj.readLine();
					System.out.println("Enter User Distance from the Point");
					int udis = Integer.parseInt(obj.readLine());
					TaxiUser data = addUser(uname,age,gender,phone,udis);
					System.out.println("Taxi Nearest to the User");
					System.out.println(calculateNearestTaxi(data));
				}else {
					System.out.println("Please Enter Taxi Details First");
				}
			break;
			default:
				next = false;
			}
		}while(next);
		
	}
	public static void addTaxi(int num,String name,int id,int dis) {
		if(name.length()>0 && id > 0 && dis > 0) {
			taxi[taxi_index++] = new Taxi(num,name,id,dis);	
		}else {
			System.out.println("Sorry Invalid Taxi Data");
		}
	}
	public static TaxiUser addUser(String name,int age,String gender,String phone,int dis) {
		int i = user_index;
		if(name.length()>0 && age>0 && phone.length()==10 && dis>0) {
			user[user_index++] = new TaxiUser(name,age,gender,phone,dis);
		}else {
			System.out.println("Invalid Data added Try again Later");
		}
		return user[i];
	}
	public static boolean isDriverIdPresent(int id) {
		for(int i=0;i<taxi_index;i++) {
			if(taxi[i].getId() == id) {
				return true;
			}
		}
		return false;
	}
	public static boolean isTaxiNumPresent(int num) {
		for(int i=0;i<taxi_index;i++) {
			if(taxi[i].getNum() == num) {
				return true;
			}
		}
		return false;
	}
	public static Taxi calculateNearestTaxi(TaxiUser u) {
		int[] near = new int[taxi_index];
		for(int i=0;i<taxi_index;i++) {
			near[i] = -1;
		}
		for(int i=0;i<taxi_index;i++) {
			near[i] = Math.abs(taxi[i].getDis() - u.getDis());
		}
		int nearest = near[0];
		int pos = 0;
		for(int i=0;i<taxi_index;i++) {
			if(near[i]<nearest && near[i]!=-1) {
				nearest = near[i];
				pos = i;
			}
		}
		return taxi[pos];
	}
}
