package racinggame;

import nextstep.utils.Randoms;

public class Car {
	private RacingBar racingBar;
	private CarName name;

	public Car(CarName name) {
		this.name = name;
		racingBar = new RacingBar(0);
	}

	public void race() {
		int randomNo = Randoms.pickNumberInRange(0, 9);
		racingBar.addBy(randomNo);
	}

	public ProgressBar getProgressBar() {
		return new ProgressBar(name, racingBar);
	}

	public CarName getCarName() {
		return name;
	}

	public int subtractRacingState(Car car) {
		return this.racingBar.getState()-car.racingBar.getState();
	}

	public boolean hasSameStateAs(Car car) {
		return racingBar.equals(car.racingBar);
	}
}
