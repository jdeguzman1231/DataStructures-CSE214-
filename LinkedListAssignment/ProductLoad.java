
public class ProductLoad {
	String name; 
	double weight;
	double dollars;
	boolean isDangerous;
	
	public ProductLoad()
	{
		
	}
	
	public ProductLoad(String name, double weight, double dollars, boolean isDangerous)
	{
		this.name = name;
		this.weight = weight;
		this.dollars = dollars;
		this.isDangerous = isDangerous;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getDollars() {
		return dollars;
	}

	public void setDollars(double dollars) {
		this.dollars = dollars;
	}

	public boolean isDangerous() {
		return isDangerous;
	}

	public void setDangerous(boolean isDangerous) {
		this.isDangerous = isDangerous;
	}
	
}
