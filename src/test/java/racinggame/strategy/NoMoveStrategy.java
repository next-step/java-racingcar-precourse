package racinggame.strategy;

public class NoMoveStrategy implements MoveStrategy{
	@Override
	public boolean isMovable() {
		return false;
	}
}
