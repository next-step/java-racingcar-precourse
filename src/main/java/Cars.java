import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Cars {
	private List<Car> cars;
	
	public Cars(String[] carStrings) {
		this.cars = setCarList(carStrings);
	}
	
	public List<Car> getCarList() {
		return cars;
	}
	
	public List<Car> setCarList(String[] carStrings) {
		List<Car> cars = new ArrayList<>();
		for(String car : carStrings) {
			cars.add(new Car(car));
		}
		return cars;
	}
	
}
