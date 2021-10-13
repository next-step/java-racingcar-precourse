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

	/**
	 * 입력받은 문자열로 자동차이름들 생성후 레이싱 객체에 전달
	 *
	 * @param input 입력받은 문자열
	 */
	public void setRacingCars(String input) {
		CarNames carNames = new CarNames(input);
		racing.joinList(carNames);
	}

	/**
	 * 입력받은 문자열로 시도 회수 생성후 레이싱 객체에 전달
	 *
	 * @param input 입력받은 문자열
	 */
	public void setTryCount(String input) {
		TryCount tryCount = new TryCount(input);
		racing.setTryCount(tryCount);
	}

	/**
	 * 레이싱 시작 및 결과 반환
	 */
	public String start() {
		RacingResults racingResults = racing.startRacing();
		return racingResults + NEW_LINE;
	}

	/**
	 * 우승자 반환
	 */
	public String getWinner() {
		return racing.getWinners().toString();
	}

}
