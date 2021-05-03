package racingcar;

import static racingcar.Utils.*;

public class RacingCar {
	private Cars cars;

	public void start() {
		initCars();
	}

	private void initCars() {
		try {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
			cars = new Cars(splitByComma(getStringInput()));
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			initCars();
		}
	}

}
