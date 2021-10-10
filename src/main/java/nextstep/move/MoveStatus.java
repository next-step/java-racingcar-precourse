package nextstep.move;

public enum MoveStatus {
	MOVE,
	STOP;

	public static boolean isMove(MoveStatus move) {
		return MoveStatus.MOVE == move;
	}
}
