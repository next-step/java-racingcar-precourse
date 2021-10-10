package racinggame.strategy;

public class AlwaysMoveStrategy implements MoveStrategy{

	@Override
	public boolean isMovable() {
		return true;
	}
}
