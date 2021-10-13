package racinggame.domain;

import static racinggame.common.CommonConstants.*;

import racinggame.common.ErrorMessage;

/**
 * 자동차 클래스
 *
 * @author Lee JungHo <jparangdev@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Car {

	private String name;
	private int distance;

	public Car(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		validCarNameLength(name);
		this.name = name;
	}

	public int getDistance() {
		return distance;
	}

	/**
	 * 자동차의 전진
	 */
	public void go() {
		distance++;
	}

	/**
	 * 자동차의 전진 여부를 결정
	 *
	 * @param randomValue 랜덤으로 입력되는 0~9까지 정수값값
	 */
	public void race(int randomValue) {
		if (randomValue >= GO_VALUE) {
			go();
		}
	}

	/**
	 * 자동차의 현자 상태를 문자열로 반환
	 *
	 * @return 자동차의 이름과 이동한 거리를 - 문자로 표현
	 */
	@Override
	public String toString() {
		StringBuilder disStr = new StringBuilder();
		for (int i = 0; i < distance; i++) {
			disStr.append(DISTANCE_STR);
		}
		return String.format(CAR_STRING_FORMAT, name, disStr);
	}

	/**
	 * 자동차 이름은 1자 이상 5자 이하여야 함
	 *
	 * @throws IllegalArgumentException 잘못된 입력의 예외
	 */
	private void validCarNameLength(String input) {
		if (input == null || input.trim().length() < NAME_MIN_LENGTH || input.trim().length() > NAME_MAX_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_CAR_INPUT_NAME);
		}
	}

}
