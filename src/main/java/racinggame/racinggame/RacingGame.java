package racinggame.racinggame;

import racinggame.circuit.FinalRecord;
import racinggame.circuit.Lap;
import racinggame.circuit.RacingCars;

public final class RacingGame {
	private final Circuit circuit;

	public RacingGame(Circuit circuit) {
		this.circuit = circuit;
	}

	/**
	 * 레이싱 게임을 시작한다.
	 * 게임 종료 후 결과를 발표한다.
	 */
	public FinalRecord play(RacingCars racingCars, Lap lap) {
		return circuit.start(racingCars, lap);
	}

}
