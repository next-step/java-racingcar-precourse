package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {
	public static final String WINNER_MSG = "최종 우승자: ";
	private Cars cars;
	
	public Winner(Cars cars2) {
		cars = new Cars(getWinners(cars2));
	}
	
	private List<Car> getWinners(Cars cars2) {
		List<Car> tmpCars = new ArrayList<Car>();
		for(Car car: cars2.getCars()) {
			tmpCars.add(new Car(car.getName(), car.getPosition()));
		}
		tmpCars.sort(null);
		return tmpCars.subList(tmpCars.indexOf(max(tmpCars)), tmpCars.size());
	}
	
	private Car max(List<Car> cars) {
		return cars.get(cars.size()-1);
	}
	
	@Override
	public String toString() {
		String[] str = new String[cars.getCars().size()];
		for(int i=0;i<cars.getCars().size();i++) {
			str[i] = cars.getCars().get(i).getName();
		}
		return WINNER_MSG + String.join(",", str);
	}
}
