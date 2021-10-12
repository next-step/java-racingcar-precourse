package racinggame.domain;

public class CarName {
	static final String ERROR_MESSAGE = "[ERROR] 자동차의 이름은 5자 이하입니다. 다시 입력해주세요.";
	private static final int INPUT_LIMIT = 5;

	private String carName;

	CarName(String carName) {
		this.carName = carName;
	}

	public String value() {
		return carName;
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/10 3:48 오후
	 * @Description : 사용자의 입력값 중 다섯 글자 이상의 자동차 이름이 포함되었는 지를 검증하는 메소드
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
		return carName;
	}
}
