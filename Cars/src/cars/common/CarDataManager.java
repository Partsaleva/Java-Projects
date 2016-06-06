package cars.common;
//just test
public class CarDataManager {

	Car car;
	
	public int removeFuel(int minusFuel){	
		int fuel=car.getFuel()-minusFuel;	
		if (fuel<0) {
			return 0;
		}
		return fuel;	
	}
}
