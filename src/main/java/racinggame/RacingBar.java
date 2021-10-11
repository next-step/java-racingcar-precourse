package racinggame;

public class RacingBar {
	private int bar;

	public void addBy(int randomNo) {
		if (randomNo <= 3) {
			return;
		}

		bar++;
	}

	public int getCurrentBar() {
		return bar;
	}
}
