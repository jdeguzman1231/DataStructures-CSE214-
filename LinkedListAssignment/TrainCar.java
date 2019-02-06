
public class TrainCar {
	double length;
	double weight;
	ProductLoad load = new ProductLoad();
	
	public TrainCar()
	{
		
	}
	
	public TrainCar(double length, double weight, ProductLoad load)
	{
		this.length = length;
		this.weight = weight;
		this.load = load;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public ProductLoad getLoad() {
		return load;
	}

	public void setLoad(ProductLoad load) {
		this.load = load;
	}
	
	
}
