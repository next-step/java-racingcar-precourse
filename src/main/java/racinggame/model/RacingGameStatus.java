package racinggame.model;

import java.util.List;

public class RacingGameStatus {
	private String racingGameStatus;

	public RacingGameStatus(List<Car> cars) {
		StringBuffer sbStatus = new StringBuffer();
		for (Car car : cars) {
			sbStatus.append(car.getStatus());
			sbStatus.append("\n");
		}
		racingGameStatus = sbStatus.toString();
	}

	
	@Override
	public String toString() {
		return racingGameStatus;
	}
}
