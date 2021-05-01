import java.util.ArrayList;
import java.util.List;

public class RacingCars {
	private final List<RacingCar> cars;

	RacingCars(String[] cars) {
		this.cars = mapRacingCar(cars);
	}

	private static List<RacingCar> mapRacingCar(String[] carNames) {
		List<RacingCar> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new RacingCar(carName));
		}
		return cars;
	}

	public static boolean isNull(RacingCars racingCars) {
		return racingCars == null;
	}
}
