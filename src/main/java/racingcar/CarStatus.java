package racingcar;

public enum CarStatus {
	STOP, GO;
	public boolean isGo() {
		return this == GO;
	}

	public boolean isStop() {
		return this == STOP;
	}
}
