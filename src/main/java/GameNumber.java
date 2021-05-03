import java.util.Random;

public class GameNumber {
	private static Random random = new Random();
	private final int MIN = 0;
	private final int MAX = 9;

	private int number;

	public GameNumber() {
		this.number = generate();
	}

	public int getNumber() {
		return this.number;
	}

	boolean isValid(int no) {
		return no >= MIN && no <= MAX;
	}

	int generate() {
		return random.nextInt(MAX - MIN) + MIN;
	}
}
