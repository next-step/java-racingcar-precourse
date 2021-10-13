package racinggame.circuit;

import java.util.ArrayList;
import java.util.List;

import racinggame.racingcar.LapRecord;
import racinggame.racingcar.Movement;
import racinggame.racingcar.RacingCar;

public final class RacingCars {
	private final List<RacingCar> racingCars = new ArrayList<>();

	public void add (RacingCar racingCar){
		this.racingCars.add(racingCar);
	}

	/**
	 * 랩 별로 레이싱을 시작한다.
	 * 주사위를 던지고, 주사위의 값을 판별해 레이싱카의 움직임을 결정한다.
	 *
	 * @return {@link LapRecords}
	 */
	public LapRecords run(Dice dice, MovementRule movementRule) {
		LapRecords lapRecords = new LapRecords();
		racingCars.forEach(car -> {
			int diceResult = dice.roll();
			Movement movement = movementRule.judgeMovement(diceResult);
			LapRecord record = car.pushPedal(movement);
			lapRecords.add(record);
		});

		return lapRecords;
	}

}
