package racinggame.domain;

import java.util.Objects;

public class Car {
	static final String ERROR_MESSAGE = "[ERROR] 자동차의 이름은 5자 이하입니다. 다시 입력해주세요.";
	private static final int INPUT_LIMIT = 5;
	private CarName carName;
	private Distance distance;

	Car(String carName) {
		this.carName = new CarName(carName);
	}

	public CarName carName() {
		return carName;
	}

	public Distance distance() {
		return distance;
	}

	public void distance(int random) {
		if (Objects.isNull(this.distance)) {
			this.distance = new Distance();
		}
		this.distance.distance(random);
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/10 3:48 오후
	 * @Description :사용자의 입력값 중 다섯 글자 이상의 자동차 이름이 포함되었는 지를 검증하는 메소드
	 *
	 **/
	public static boolean isOverThanFiveLetters(String input) {
		if (input.length() > INPUT_LIMIT) {
			System.out.println(ERROR_MESSAGE);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return carName + " : " + distance;
	}
}
