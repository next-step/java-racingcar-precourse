package racinggame;

import java.util.Objects;

public class ProgressBar {
	private final CarName carName;
	private final RacingBar racingBar;

	public ProgressBar(CarName carName, RacingBar racingBar) {
		this.carName = carName;
		this.racingBar = racingBar;
	}

	@Override
	public String toString() {
		return carName + " : " + mapToStringBar();
	}

	private String mapToStringBar() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < racingBar.getState(); i++) {
			sb.append("-");
		}

		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ProgressBar that = (ProgressBar)o;
		return Objects.equals(carName, that.carName) && Objects.equals(racingBar, that.racingBar);
	}

	@Override
	public int hashCode() {
		return Objects.hash(carName, racingBar);
	}
}
