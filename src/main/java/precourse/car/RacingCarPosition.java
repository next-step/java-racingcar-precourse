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

	public int getNumber() {
		return position;
	}

}
