package racingcar.domain;

import org.junit.platform.commons.util.ToStringBuilder;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private static final int RANDOM_MIN_NO = 0;
	private static final int RANDOM_MAX_NO = 9;
	private static final int FORWARD_NUM = 4;

	private final Name name;
	private final Position position;

	public Car(final Name name) {
		this.name = name;
		this.position = new Position();
	}

	//== 비지니스 로직 ==//
	public void move() {
		if (getRandomNo() >= FORWARD_NUM) {
			position.move();
		}
	}

	protected int getRandomNo() {
		return Randoms.pickNumberInRange(RANDOM_MIN_NO, RANDOM_MAX_NO);
	}

	public String getName() {
		return name.getName();
	}

	public Position getPosition() {
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
