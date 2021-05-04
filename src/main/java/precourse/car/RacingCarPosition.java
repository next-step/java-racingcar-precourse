package precourse.car;

public class RacingCarPosition {

	private static final String POSITION_SYMBOL = "-";
	private int position;

	public void moveForward() {
		position++;
	}

	public String describeAsSymbol() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < position; i++) {
			builder.append(POSITION_SYMBOL);
		}
		return builder.toString();
	}

	public boolean isMaxPosition(int maxPosition) {
		return position == maxPosition;
	}

	public int getValue() {
		return position;
	}

}
