package IntegratedPracticeProblem.GiftShop;

public class Gift {
private int itemCode;
private String name;
private int price;
private String category;
private int quantity;
public Gift(int itemCode, String name, int price, String category, int quantity) {
	this.itemCode = itemCode;
	this.name = name;
	this.price = price;
	this.category = category;
	this.quantity = quantity;
}
public int getItemCode() {
	return itemCode;
}
public void setItemCode(int itemCode) {
	this.itemCode = itemCode;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "Gift [itemCode=" + itemCode + ", name=" + name + ", price=" + price + ", category=" + category
			+ ", quantity=" + quantity + "]";
}
}
