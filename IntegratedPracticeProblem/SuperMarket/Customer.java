package IntegratedPracticeProblem.SuperMarket;

import java.util.Arrays;

public class Customer {
private String name;
private String phone;
private int amount;
private Bill[] purchase;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public Bill[] getPurchase() {
	return purchase;
}
public void setPurchase(Bill[] purchase) {
	this.purchase = purchase;
}
public Customer(String name, String phone, int amount, Bill[] purchase) {
	this.name = name;
	this.phone = phone;
	this.amount = amount;
	this.purchase = purchase;
}
@Override
public String toString() {
	return "Customer [name=" + name + ", phone=" + phone + ", amount=" + amount + ", purchase="
			+ Arrays.toString(purchase) + "]";
}

}
