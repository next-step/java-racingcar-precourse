package racinggame.circuit;

import racinggame.racinggame.Circuit;

public class RacingCircuit implements Circuit {
	private final Dice dice;
	private final MovementRule movementRule;

	public RacingCircuit(Dice dice, MovementRule movementRule) {
		this.dice = dice;
		this.movementRule = movementRule;
	}

	/**
	 * {@link RacingCars} : 경기에 참가하는 레이싱카들
	 * {@link Lap}        : 경기를 반복하는 횟수
	 *
	 * 지정한 랩 만큼 경기를 반복한다.
	 * 최종결과를 반환한다.
	 *
	 * @param racingCars
	 * @param laps
	 * @return
	 */
	@Override
	public FinalRecord start(RacingCars racingCars, Lap laps) {
		FinalRecord finalRecord = new FinalRecord();

		for (int lap = 0; lap < laps.getLaps(); ++lap) {
			finalRecord.add(racingCars.run(dice, movementRule));
		}

		return finalRecord;
	}
}
