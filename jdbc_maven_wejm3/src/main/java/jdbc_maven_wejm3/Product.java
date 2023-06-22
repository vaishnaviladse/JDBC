package jdbc_maven_wejm3;

public class Product {
	private int id;
	private String name;
	private int cost;
	private String manufacture;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

}
