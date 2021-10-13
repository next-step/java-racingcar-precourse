package racinggame.racingcar;

import racinggame.common.RacingCarName;

public final class RacingCar {
	private final RacingCarName racingCarName;

	private Location location = new Location(0);

	public RacingCar(final RacingCarName racingCarName) {
		this.racingCarName = racingCarName;
	}

	/**
	 * 새로운 위치로 이동한다.
	 *
	 * @return {@link LapRecord}
	 */
	public LapRecord pushPedal(final Movement movement) {
		this.location = location.forward(movement);

		return new LapRecord(racingCarName, location);
	}
}
