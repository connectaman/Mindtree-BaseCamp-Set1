package IntegratedPracticeProblem.GiftShop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class GiftShop {
	public static Gift[] gift = new Gift[10];
	public static Bill[] bill = new Bill[10];
	public static int gift_index = 0;
	public static int bill_index = 0;
	public static void main(String[] args)throws IOException {
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		boolean next = true;
		do {
			System.out.println("1 - Add Gift Item");
			System.out.println("2 - Add Bill");
			System.out.println("3 - Search Special Buyers");
			System.out.println("4 - Exit");
			System.out.println("Enter the choice");
			int choice = Integer.parseInt(obj.readLine());
			switch(choice) {
			case 1:
				System.out.println("Enter the item Code");
				int id = Integer.parseInt(obj.readLine());
				if(isItemCodeAvailable(id)) {
					System.out.println("Item Id already present");
				}
				if(id<=0) {
					System.out.println("Invaid Id ");
					break;
				}
				System.out.println("Enter the Item Name");
				String name = obj.readLine();
				if(name.length()<=0) {
					System.out.println("Invalid Name");
					break;
				}
				System.out.println("Enter item Price");
				int price = Integer.parseInt(obj.readLine());
				if(price <= 0) {
					System.out.println("Invalid Price");
					break;
				}
				System.out.println("Enter the Category");
				String cat  = obj.readLine();
				if(cat.length()<=0) {
					System.out.println("Invalid Category");
					break;
				}
				System.out.println("Enter the Quantity");
				int quant = Integer.parseInt(obj.readLine());
				if(quant<=0) {
					System.out.println("Invalid Quantity");
					break;
				}
				gift[gift_index++] = new Gift(id,name,price,cat,quant);
			break;
			case 2:
				System.out.println("Enter the Item Code");
				int code = Integer.parseInt(obj.readLine());
				if(!isItemCodeAvailable(code)) {
					System.out.println("Item Id Not Present in Items");
				}
				if(code<=0) {
					System.out.println("Invaid Id ");
					break;
				}
				System.out.println("Enter the Buyer Name");
				String bname = obj.readLine();
				if(bname.length()<=0) {
					System.out.println("Invalid Name");
					break;
				}
				System.out.println("Enter Buyer Special Day Date of Birth in DD:MM:YYYY format");
				String sday = obj.readLine();
				System.out.println("Enter Buyer Special Day Anniversary in DD:MM:YYYY Format");
				String dani = obj.readLine();
				System.out.println("Enter the Quantity Buyer Buying");
				int q = Integer.parseInt(obj.readLine());
				int availableQuantity = getQuantityById(code);
				if(availableQuantity==0) {
					System.out.println("The Item is out of Stock");
					break;
				}
				if(q > availableQuantity) {
					System.out.println("Sorry you have"+availableQuantity+" left");
				}else {
					updateQuantity(q,code);
				}
				int mrp = getItemPrice(code);
				int amount = mrp*q;
				bill[bill_index++] = new Bill(code,bname,sday,dani,q,amount);
			break;
			case 3:
				System.out.println("Enter the present Month in MM format");
				int month = Integer.parseInt(obj.readLine());
				if(month<1 && month >12) {
					System.out.println("Invalid Month");
					break;
				}
				Bill[] cust = getSpecialCustomerBySpecialDay(month);
				System.out.println("Specials Customer whos Sepcial Day is next Month");
				for(int i=0;i<cust.length;i++) {
					if(cust[i]!=null) {
						System.out.println(cust[i]);
					}
				}
			break;
			default:
				next = false;
			}
		}while(next);

	}
	public static boolean isItemCodeAvailable(int id) {
		for(int i=0;i<gift_index;i++) {
			if(gift[i].getItemCode() == id) {
				return true;
			}
		}
		return false;
	}
	public static int getQuantityById(int itemid) {
		int q = 0;
		for(int i=0;i<gift_index;i++) {
			if(gift[i].getItemCode() == itemid) {
				q = gift[i].getQuantity();
			}
		}
		return q;
	}
	public static void updateQuantity(int q,int id) {
		for(int i=0;i<gift_index;i++) {
			if(gift[i].getItemCode() == id) {
				//int quant = gift[i].getQuantity();
				gift[i].setQuantity(q -  gift[i].getQuantity());
				System.out.println(gift[i]);
			}
		}
	}
	public static int getItemPrice(int id) {
		int mrp = 0;
		for(int i=0;i<gift_index;i++) {
			if(gift[i].getItemCode() == id) {
				mrp = gift[i].getPrice();
			}
		}
		return mrp;
	}
	public static Bill[] getSpecialCustomerBySpecialDay(int month) {
		String[] months = {"Jan","Feb","Mar","April","Map","June","July","August","Sept","Oct","Nov","Dec"};
		Bill[] special = new Bill[bill_index];
		int j = 0;
		for(int i=0;i<bill_index;i++) {
			int sb=0,sa=0;
			if(bill[i].getSpecial_DOB().length()>0) {
				sb = Integer.parseInt(bill[i].getSpecial_DOB().charAt(3)+""+bill[i].getSpecial_DOB().charAt(4));
			}
			if(bill[i].getSpecialAn().length()>0) {
				sa =  Integer.parseInt(bill[i].getSpecialAn().charAt(3)+""+bill[i].getSpecialAn().charAt(4));
			}
			if(sa!=0 || sb!=0) {
				if(sa==(month+1) || (sb==(month+1))) {
					special[j++] = bill[i];
				}
			}
		}
		return special;
	}
}
