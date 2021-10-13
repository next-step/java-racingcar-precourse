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
	 * 게임 종료 후 기록을 반환한다.
	 *
	 * @return {@link FinalRecord} 경기 진행 결과를 반환한다.
	 */
	public FinalRecord play(RacingCars racingCars, Lap lap) {
		return circuit.start(racingCars, lap);
	}

}
