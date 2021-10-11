package racinggame;

public enum RacingStatus {
	GO, STOP;

	public Boolean isGo() {
		return this.equals(GO);
	}
}
