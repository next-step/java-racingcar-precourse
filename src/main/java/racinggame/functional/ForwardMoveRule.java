package racinggame.functional;

@FunctionalInterface
public interface ForwardMoveRule {
	boolean isMovable();

	static ForwardMoveRule alwaysForwardMove() {
		return () -> true;
	}
}