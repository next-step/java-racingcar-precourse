package racinggame.circuit;

import java.util.List;

import racinggame.racingcar.LapRecord;
import racinggame.racingcar.RacingCar;

public final class RacingCars {
	private final List<RacingCar> racingCars;

	public RacingCars(List<RacingCar> racingCars) {
		this.racingCars = racingCars;
	}

	/**
	 * 랩 별로 레이싱을 시작한다.
	 * 레이싱카마다 결과를 반환한다.
	 *
	 * @return {@link LapRecords}
	 */
	public LapRecords run() {
		LapRecords lapRecords = new LapRecords();
		racingCars.forEach(car -> {
			LapRecord record = car.pushPedal();
			lapRecords.add(record);
		});

		return lapRecords;
	}

}
