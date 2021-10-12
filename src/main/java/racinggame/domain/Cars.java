package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	static final String ERROR_MESSAGE = "[ERROR] 자동차의 이름은 5자 이하입니다. 다시 입력해주세요.";
	private final List<Car> cars = new ArrayList<>();

	private Cars(List<String> carNames) {
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	public static Cars init(List<String> carNames) {
		return new Cars(carNames);
	}

	public List<Car> value() {
		return cars;
	}
}
