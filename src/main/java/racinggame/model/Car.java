package racinggame.model;

import java.util.Collections;

import nextstep.utils.Randoms;

public class Car {
	public static final int MIN_VALUE_FORWARD = 4;
	
	private CarName carName;
	private TotalTravel totalTravel;

	public Car(String name) {
		carName = new CarName(name);
		totalTravel = new TotalTravel();
	}

	String getName() {
		return carName.toString();
	}

	/**
	 * 자동차 전진 체크
	 * @param value 랜덤 값 1 ~ 9
	 * @return 체크 결과 전진 혹은 멈춤.
	 */
	CarPlayResult play(int value) {
		return value < MIN_VALUE_FORWARD ? CarPlayResult.STOP : CarPlayResult.FORWARD;
	}

	/**
	 * 자동차 진행
	 */
	public void roll() {
		CarPlayResult result = play(Randoms.pickNumberInRange(0, 9));
		if (result.isForward()) {
			totalTravel.moveForward();
		}
	}

	int getTotalTravel() {
		return totalTravel.get();
	}

	/**
	 * 자동차 현재 상태 반환
	 * @return 자동차 현재 상태 문자열
	 */
	public String getStatus() {
		return carName + " : " + String.join("", Collections.nCopies(totalTravel.get(), "-"));
	}
}
