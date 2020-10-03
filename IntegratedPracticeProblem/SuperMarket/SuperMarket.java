package IntegratedPracticeProblem.SuperMarket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// Problem No 4
public class SuperMarket {
	public static Items[] item = new Items[10];
	public static Bill[] bill = new Bill[10];
	public static Customer[] customer = new Customer[10];
	public static int item_index = 0;
	public static int bill_index = 0;
	public static int customer_index = 0;
	public static int total_amt = 0;
	public static int grand_amt = 0;
	public static void main(String[] args)throws IOException {
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		
		boolean next = true;
		do {
			System.out.println("1 - Enter an item to cart");
			System.out.println("2 - Generate Bill for a Customer");
			System.out.println("3 - Display the Most Item Sold Till Now");
			System.out.println("4 - Find the Most Valued Customer");
			System.out.println("5 - Exit");
			System.out.println("Enter your choice");
			int choice = Integer.parseInt(obj.readLine());
			switch(choice) {
			case 1:
				System.out.println("Enter Item to Cart : ");
				System.out.println("Enter Item id");
				int id = Integer.parseInt(obj.readLine());
				if(!isItemPresentInCart(id)) {
					System.out.println("Enter Item Name");
					String name = obj.readLine();
					System.out.println("Enter Item MRP");
					int mrp = Integer.parseInt(obj.readLine());
					if(id>0 && name.length()>0 && mrp>0) {
						item[item_index++] = new Items(id,name,mrp,0);
						System.out.println("Item Added to Cart Success");
					}
				}else {
					System.out.println("Sorry the ItemId is Already Present in the Cart");
				}
			break;
			case 2:
				System.out.println("Enter the Customer Name");
				String cus_name = obj.readLine();
				System.out.println("Enter the Customer Phone Number");
				String phone = obj.readLine();
				boolean isNext  = true;
				System.out.println("Generate Bill for the Customer");
				do {
					displayAllItemsInCart();
					System.out.println("Please Enter the Item Id ");
					int item_id = Integer.parseInt(obj.readLine());
					if(isItemPresentInCart(item_id)) {
						System.out.println("Enter the quantity of Item");
						int quant = Integer.parseInt(obj.readLine());
						int mrp_item = getItemPrice(item_id);
						int item_price = quant * mrp_item;
						total_amt+=item_price;
						grand_amt+=total_amt;
						bill[bill_index++] = new Bill(item_id,quant,mrp_item,item_price,0);
						increaseTheItemCount(item_id);
						System.out.println("Do you want to add more item to customer cart? [1/0]");
						int next_choice = Integer.parseInt(obj.readLine());
						isNext = (next_choice==1)?true:false;
					}else {
						System.out.println("Sorry the ItemId Entered is not present in the Cart");
					}
				}while(isNext);
				System.out.println("Any Discount for the Customer? (If yes then enter the percent else enter 0)");
				float discount = Float.parseFloat(obj.readLine());
				float grand_total = 0;
				if(discount!=0) {
					grand_total = (float)(discount/100) * total_amt;
					System.out.println(grand_total);
				}
				customer[customer_index++] = new Customer(cus_name,phone,(int)(total_amt+grand_total),bill);
				bill = new Bill[10];
				bill_index=0;
				total_amt = 0;
				System.out.println("Total Amount to be paid by Customer : "+grand_total);
			break;
			case 3:
				if(item_index!=0 || item_index>0) {
					Items most = getMostPurchasedItem();
					System.out.println("The Most Item Purchased : ");
					System.out.println(most);	
				}else {
					System.out.println("Sorry No item Purchased Yet");
				}
			break;
			case 4:
				if(customer_index!=0 || customer_index>0) {
					Customer value = getMostValuedCustomer();
					System.out.println("The Most Valued Customer : ");
					System.out.println(value);
				}else {
					System.out.println("Sorry No Customer is Added");
				}
			break;
			case 5:
				next = false;
			break;
			default:
				next = false;
			}
		}while(next);
	}
	public static boolean isItemPresentInCart(int id) {
		for(int i=0;i<item_index;i++) {
			if(item[i].getId() == id) {
				return true;
			}
		}
		return false;
	}
	public static int getItemPrice(int id) {
		int mrp = 0;
		for(int i=0;i<item_index;i++) {
			if(item[i].getId() == id) {
				mrp = item[i].getMrp();
			}
		}
		return mrp;
	}
	public static Items getMostPurchasedItem() {
		int max = item[0].getCount();
		int max_pos = 0;
		for(int i=0;i<item_index;i++) {
			if(item[i].getCount() > max) {
				max = item[i].getCount();
				max_pos = i;
			}
		}
		return item[max_pos];
	}
	public static Customer getMostValuedCustomer() {
		int max = customer[0].getAmount();
		int max_pos = 0;
		for(int i=0;i<customer_index;i++) {
			if(customer[i].getAmount() > max) {
				max = customer[i].getAmount();
				max_pos = i;
			}
		}
		return customer[max_pos];
	}
	public static void displayAllItemsInCart() {
		for(int i=0;i<item_index;i++) {
			System.out.println(item[i]);
		}
	}
	public static void increaseTheItemCount(int id) {
		for(int i=0;i<item_index;i++) {
			if(item[i].getId() == id) {
				item[i].setCount(item[i].getCount()+1);
			}
		}
	}

}
