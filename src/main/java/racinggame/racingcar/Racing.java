package racinggame.racingcar;

public enum Racing {
	STOP(0), FORWARD(1);

	private final int value;

	Racing(int value) {
		this.value = value;
	}

	/**
	 * 상태별 이동 가능한 거리를 반환한다.
	 *
	 * @return
	 */
	public int movable() {
		return this.value;
	}
}
