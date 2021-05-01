package racingcar;

public class Car {

	private String name;

	private String moves;

	public Car(String name) {
		this.name = name;
		this.moves = "";
	}

	public String getName() {
		return name;
	}

	public String getMoves() {
		return moves;
	}

	public boolean isWinner(int moveCount) {
		return moves.length() == moveCount;
	}

	public void go() {
		moves += "-";
	}

	public int getMovesSize() {
		return moves.length();
	}
}