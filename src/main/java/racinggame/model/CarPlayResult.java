package racinggame.model;

public enum CarPlayResult {
	STOP, FORWARD;

	boolean isForward() {
		return this == FORWARD;
	}

}
