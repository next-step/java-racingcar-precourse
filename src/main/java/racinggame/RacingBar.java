package racinggame;

import java.util.Objects;

public class RacingBar {
	private int state;

	public RacingBar(int state) {
		this.state = state;
	}

	public void addBy(int randomNo) {
		if (randomNo <= 3) {
			return;
		}

		state++;
	}

	public int getState() {
		return state;
	}

	public boolean isBiggerThan(RacingBar racingBar) {
		return this.state > racingBar.state;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RacingBar racingBar = (RacingBar)o;
		return state == racingBar.state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(state);
	}
}
