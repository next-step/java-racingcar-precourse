package domain.car.strategy;

public class ConditionMovableStrategy implements MovableStrategy {

	private final boolean condition;

	public ConditionMovableStrategy(boolean condition) {
		this.condition = condition;
	}

	@Override
	public boolean movable() {
		return condition;
	}
}
