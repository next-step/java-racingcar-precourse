package racinggame.model;

import java.util.List;

public class WinnerNames {
	private String winnerName;

	public WinnerNames(List<Car> winners) {
		StringBuffer sbWinnerNames = new StringBuffer();
		for (Car car : winners) {
			sbWinnerNames.append(",");
			sbWinnerNames.append(car.getName());
		}
		winnerName = sbWinnerNames.toString().replaceFirst(",", "");
	}

	@Override
	public String toString() {
		return winnerName;
	}
}
