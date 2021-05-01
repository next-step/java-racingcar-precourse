package racingcar;

public class MoveCar {

	public MoveStatus status;

	public MoveCar(int isMoveOrStop) {
		this.status = isMoveOrStop(isMoveOrStop);
	}

	public MoveStatus isMoveOrStop(int randomNumber) {
		if (randomNumber >= 4) {
			return MoveStatus.GO;
		}
		return MoveStatus.STOP;
	}

	public boolean isGo() {
		return status == MoveStatus.GO;
	}

	public boolean isStop() {
		return status == MoveStatus.STOP;
	}
}