package racinggame.strategy;

public class FixedMovableStrategy implements MovableStrategy {

	private static final int MOVE_REQUIRED_VALUE = 4;

	private final int value;

	public FixedMovableStrategy(int value) {
		this.value = value;
	}

	@Override
	public boolean movable() {
		return value >= MOVE_REQUIRED_VALUE;
	}
}
