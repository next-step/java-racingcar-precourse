package racinggame.racingcar;

import racinggame.common.RacingCarName;
import racinggame.racinggame.Rule;

public final class RacingCar {
	private final RacingCarName racingCarName;

	private Location location = new Location(0);

	public RacingCar(RacingCarName racingCarName) {
		this.racingCarName = racingCarName;
	}

	/**
	 * 주사위의 결과에 따라 움직임을 결정한다.
	 *
	 * @return {@link LapRecord}
	 */
	public LapRecord pushPedal(Movement movement) {
		this.location = location.forward(movement);

		return new LapRecord(racingCarName, location);
	}
}
