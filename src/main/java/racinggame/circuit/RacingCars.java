package racinggame.circuit;

import java.util.ArrayList;
import java.util.List;

import racinggame.dice.Dice;
import racinggame.racingcar.LapRecord;
import racinggame.racingcar.Movement;
import racinggame.racingcar.RacingCar;
import racinggame.racinggame.Rule;

public final class RacingCars {
	private final List<RacingCar> racingCars = new ArrayList<>();

	public void add (RacingCar racingCar){
		this.racingCars.add(racingCar);
	}

	/**
	 * 랩 별로 레이싱을 시작한다.
	 * 레이싱카마다 결과를 반환한다.
	 *
	 * @return {@link LapRecords}
	 */
	public LapRecords run(Dice dice, Rule rule) {
		LapRecords lapRecords = new LapRecords();
		racingCars.forEach(car -> {
			int diceResult = dice.roll();
			Movement movement = rule.judgeMovement(diceResult);
			LapRecord record = car.pushPedal(movement);
			lapRecords.add(record);
		});

		return lapRecords;
	}

}
