import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
	public List<Car> cars = new ArrayList<>();

	public Cars(String carNames) {
		List tempCarName = Arrays.asList(carNames.split(","));
		int bound = tempCarName.size();
		for (int i = 0; i < bound; i++) {
			cars.add(new Car(tempCarName.get(i).toString(), 0));
		}
	}

	public Cars() {

	}

	public List<Car> getCars() {
		return this.cars;
	}

	public int carsNumber() {
		return cars.size();
	}

	public void addCar(Car winnerCar) {
		this.cars.add(winnerCar);
	}
}
