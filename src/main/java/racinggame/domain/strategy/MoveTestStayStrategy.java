package racinggame.domain.strategy;

public class MoveTestStayStrategy implements Strategy {

	@Override
	public boolean isMovable() {
		return false;
	}
}
