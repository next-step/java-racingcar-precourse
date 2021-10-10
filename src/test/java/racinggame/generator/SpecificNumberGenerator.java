package racinggame.generator;

public class SpecificNumberGenerator implements NumberGenerator {

	private final int number;

	public SpecificNumberGenerator(int number) {
		this.number = number;
	}

	@Override
	public int generate() {
		return number;
	}
}
