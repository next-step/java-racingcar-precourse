package racingcar.model;

public enum CarStatus {
	STOP, GO;

	public boolean isStop() {
		return this == STOP;
	}
	public boolean isGo() {
		return this == GO;
	}
}
