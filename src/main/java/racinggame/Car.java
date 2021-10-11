package racinggame;

import nextstep.utils.Randoms;

public class Car {
	private RacingBar racingBar;
	private CarName name;

	public Car(String name) {
		this.name = new CarName(name);
		racingBar = new RacingBar(0);
	}

	public void race() {
		int randomNo = Randoms.pickNumberInRange(0, 9);
		racingBar.addBy(randomNo);
	}

	public ProgressBar getProgressBar() {
		return new ProgressBar(name, racingBar);
	}
}
