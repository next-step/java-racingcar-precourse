package racinggame;

import java.util.Objects;

public class RacingBar {
	private int bar;

	public RacingBar(int bar) {
		this.bar = bar;
	}

	public void addBy(int randomNo) {
		if (randomNo <= 3) {
			return;
		}

		bar++;
	}

	public int getCurrentBar() {
		return bar;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RacingBar racingBar = (RacingBar)o;
		return bar == racingBar.bar;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bar);
	}
}
