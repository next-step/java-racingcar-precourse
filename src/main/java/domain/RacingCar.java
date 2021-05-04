package domain;

import utils.RandomNumberGenerator;
import view.OutputView;

public class RacingCar {
	private RacingCarName carName;
	private RacingPosition carPosition;

	public String getCarName() {
		return carName.getName();
	}

	public RacingPosition getPosition() {
		return carPosition;
	}

	public int getCarPosition() {
		return carPosition.getPosition();
	}

	RacingCar(String CarName) {
		this.carName = new RacingCarName(CarName);
		this.carPosition = new RacingPosition();
	}

	public void move() {
		carPosition.move(RandomNumberGenerator.getRandomNumber());
		OutputView.printCarName(getCarName());
		carPosition.printPosition();
	}

	public boolean isSamePosition(int position) {
		return getCarPosition() == position;
	}

	public boolean isCarPositionBigger(int position) {
		return getCarPosition() > position;
	}
}
