package racinggame.model;

public class MaxMoveTurn {
	private final int maxMoveTurn;

	public MaxMoveTurn(String inputTurn) {
		maxMoveTurn = Integer.parseUnsignedInt(inputTurn);
		if (maxMoveTurn < 1) {
			throw new NumberFormatException("1 이상의 자연수만 가능합니다.");
		}
	}

	public int get() {
		return maxMoveTurn;
	}
}
