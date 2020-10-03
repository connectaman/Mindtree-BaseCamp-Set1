package IntegratedPracticeProblem.SuperMarket;

public class Bill {
private int itemid;
private int quantity;
private int price;
private int total;
private int discount;
public int getItemid() {
	return itemid;
}
public void setItemid(int itemid) {
	this.itemid = itemid;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public int getDiscount() {
	return discount;
}
public void setDiscount(int discount) {
	this.discount = discount;
}
public Bill(int itemid, int quantity, int price, int total, int discount) {
	this.itemid = itemid;
	this.quantity = quantity;
	this.price = price;
	this.total = total;
	this.discount = discount;
}
@Override
public String toString() {
	return "Bill [itemid=" + itemid + ", quantity=" + quantity + ", price=" + price + ", total=" + total + ", discount="
			+ discount + "]";
}
}
