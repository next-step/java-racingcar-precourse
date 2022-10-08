package racingcar.domain;

import org.junit.platform.commons.util.ToStringBuilder;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private static final int RANDOM_MIN_NO = 0;
	private static final int RANDOM_MAX_NO = 9;
	private static final int FORWARD_NUM = 4;
	private static final int CAR_NAME_MAX_LENGTH = 5;

	private final String name;
	private int position;

	public Car(String name) {
		if (name.length() > CAR_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
		}
		this.name = name;
		this.position = 0;
	}

	//== 비지니스 로직 ==//
	public void move() {
		if (getRandomNo() >= FORWARD_NUM) {
			this.position++;
		}
	}

	protected int getRandomNo() {
		return Randoms.pickNumberInRange(RANDOM_MIN_NO, RANDOM_MAX_NO);
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("name", name)
			.append("position", position)
			.toString();
	}
}
