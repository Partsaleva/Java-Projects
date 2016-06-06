package cars.common;

public class Car {

	private String number;
	private String brand;
	private String model;
	private int fuel;
	
	public Car(String number, String brand, String model, int fuel) {
		this.number = number;
		this.brand = brand;
		this.model = model;
		this.fuel = fuel;
	}

	public String getNumber() {
		return number;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public int getFuel() {
		return fuel;
	}

	@Override
	public String toString() {
		return "Кола " + number + "(" + brand + " "
				+ model + ")\nгориво: " + fuel + "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + fuel;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (fuel != other.fuel)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
	
}
