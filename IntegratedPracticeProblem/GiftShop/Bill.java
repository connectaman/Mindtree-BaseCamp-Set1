package IntegratedPracticeProblem.GiftShop;

public class Bill {
private int itemid;
private String name;
private String special_DOB;
private String specialAn;
private int quantity;
private int totalPrice;
public Bill(int itemid, String name, String special_DOB, String specialAn, int quantity, int totalPrice) {
	this.itemid = itemid;
	this.name = name;
	this.special_DOB = special_DOB;
	this.specialAn = specialAn;
	this.quantity = quantity;
	this.totalPrice = totalPrice;
}
public int getItemid() {
	return itemid;
}
public void setItemid(int itemid) {
	this.itemid = itemid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSpecial_DOB() {
	return special_DOB;
}
public void setSpecial_DOB(String special_DOB) {
	this.special_DOB = special_DOB;
}
public String getSpecialAn() {
	return specialAn;
}
public void setSpecialAn(String specialAn) {
	this.specialAn = specialAn;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(int totalPrice) {
	this.totalPrice = totalPrice;
}
@Override
public String toString() {
	return "Bill [itemid=" + itemid + ", name=" + name + ", special_DOB=" + special_DOB + ", specialAn=" + specialAn
			+ ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
}
}
