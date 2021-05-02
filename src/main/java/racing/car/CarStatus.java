package racing.car;

public enum CarStatus {
	FORWARD, STOP;

	public boolean isForward() {
		return this == FORWARD;
	}

	public boolean isStop() {
		return this == STOP;
	}
}
