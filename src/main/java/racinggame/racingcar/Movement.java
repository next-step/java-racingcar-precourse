package racinggame.racingcar;

public enum Movement {
	STOP(0), FORWARD(1);

	private final int distance;

	Movement(int distance) {
		this.distance = distance;
	}

	/**
	 * 상태별 이동 가능한 거리를 반환한다.
	 *
	 * @return distance
	 */
	public int movable() {
		return this.distance;
	}
}
