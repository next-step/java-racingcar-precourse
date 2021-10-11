package racinggame;

import nextstep.utils.Randoms;

public class Car {
	private RacingBar racingBar;
	private final String name;

	public Car(String name) {
		validateLengthOf(name);
		this.name = name;
		racingBar = new RacingBar(0);
	}

	public void race() {
		int randomNo = Randoms.pickNumberInRange(0, 9);
		racingBar.addBy(randomNo);
	}

	private void validateLengthOf(String carName) {
		if (5 < carName.length()) {
			throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다");
		}
	}

	public ProgressBar getProgressBar() {
		return new ProgressBar(name, racingBar);
	}
}
