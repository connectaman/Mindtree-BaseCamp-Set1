package IntegratedPracticeProblem.SuperMarket;

public class Items {
	private int id;
	private String name;
	private int mrp;
	private int count;
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
	public int getMrp() {
		return mrp;
	}
	public void setMrp(int mrp) {
		this.mrp = mrp;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Items(int id, String name, int mrp, int count) {
		this.id = id;
		this.name = name;
		this.mrp = mrp;
		this.count = count;
	}
	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", mrp=" + mrp + ", count=" + count + "]";
	}
	
}
