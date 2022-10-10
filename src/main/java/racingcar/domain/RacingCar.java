package racingcar.domain;

import racingcar.constants.RacingCarMessage;
import racingcar.constants.RacingCarNum;

public class RacingCar {
	private String carName;
	private int location;

	public RacingCar(String carName) {
		if (validCarName(carName)) {
			this.carName = carName;
		}
		this.location = RacingCarNum.LOCATION_INIT;
	}

	private boolean validCarName(String name) {
		if (name == null) {
			throw new IllegalArgumentException(RacingCarMessage.MESSAGE_VALIDATION_INPUT_LENGTH);
		}
		if (name.length() > RacingCarNum.CAR_NAME_MAX || name.length() < RacingCarNum.CAR_NAME_MIN) {
			throw new IllegalArgumentException(RacingCarMessage.MESSAGE_VALIDATION_INPUT_LENGTH);
		}
		return true;
	}

	public String getCarName() {
		return carName;
	}

	public int getLocation() {
		return location;
	}

	public void playRacing(int randomNum) {
		if (randomNum >= RacingCarNum.FOWARD_NUM) {
			locationForward();
		}
	}

	private void locationForward() {
		location += RacingCarNum.FOWARD_LENGTH;
	}

}
