package racinggame.controller;

import static racinggame.common.CommonConstants.*;

import racinggame.domain.CarNames;
import racinggame.domain.Racing;
import racinggame.domain.RacingResults;
import racinggame.domain.TryCount;

/**
 * 컨트롤러 역할을 하는 개최팀 클래스
 *
 * @author Lee JungHo <jparangdev@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Host {

	Racing racing;

	public Host() {
		racing = new Racing();
	}

	public Racing getRacing() {
		return racing;
	}

	public void setRacingCars(String input) {
		CarNames carNames = new CarNames(input);
		racing.joinList(carNames);
	}

	public void setTryCount(String input) {
		TryCount tryCount = new TryCount(input);
		racing.setTryCount(tryCount);
	}

	public String start() {
		RacingResults racingResults = racing.startRacing();
		return racingResults + NEW_LINE;
	}

	public String getWinner() {
		return racing.getWinners().toString();
	}

}
