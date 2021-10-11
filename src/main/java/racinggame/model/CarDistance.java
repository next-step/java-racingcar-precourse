package racinggame.model;

import nextstep.utils.Randoms;

/**
 * @auhor Kim JeongJin <kingroma92@gmail.com>
 * @version 1.0
 * @since 1.0
 * */
public class CarDistance {
	private String carDistance = "";

	public void moveOrStop() {
		int num = Randoms.pickNumberInRange(0, 9);

		if (num >= 4) {
			addCarDistance();
		}
	}
	
	private void addCarDistance() {
		this.carDistance += "-";
	}
	
	public String getCarDistance() {
		return carDistance;
	}

	public void setCarDistance(String carDistance) {
		this.carDistance = carDistance;
	}

}
