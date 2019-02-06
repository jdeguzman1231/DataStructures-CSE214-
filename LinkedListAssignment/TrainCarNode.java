
public class TrainCarNode 
{
	TrainCarNode prev;
	TrainCarNode next;
	TrainCar car;
	
	TrainCarNode()
	{
		
	}
	
	TrainCarNode(TrainCar car)
	{
		this.car = car;
	}

	public TrainCarNode getPrev() {
		return prev;
	}

	public void setPrev(TrainCarNode prev) {
		this.prev = prev;
	}

	public TrainCarNode getNext() {
		return next;
	}

	public void setNext(TrainCarNode next) {
		this.next = next;
	}

	public TrainCar getCar() {
		return car;
	}

	public void setCar(TrainCar car) {
		this.car = car;
	}
	
	public String toString()
	{
		String s = "";
		return s;
	}
}
