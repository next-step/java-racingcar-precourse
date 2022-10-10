package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.StringUtils;

public class Cars {
	private List<Car> carList;

	public Cars(CarsBuilder carsBuilder) {
		this.carList = carsBuilder.carList;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void moveCars() {
		for (Car car : carList) {
			car.moveCar();
		}
	}

	public static class CarsBuilder {
		private List<Car> carList = new ArrayList<>();

		public CarsBuilder carList(String input) {
			this.carList = convertInputToCarList(input);
			return this;
		}

		public List<Car> convertInputToCarList(String input) {
			for (String name : StringUtils.convertInputToStringArray(input)) {
				carList.add(new Car.CarBuilder().name(name.trim()).build());
			}
			return this.carList;
		}

		public Cars build() {
			return new Cars(this);
		}
	}
}
