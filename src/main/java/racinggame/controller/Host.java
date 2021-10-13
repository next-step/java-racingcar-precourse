package racinggame.controller;

import static racinggame.common.CommonConstants.*;
import static racinggame.common.ErrorMessage.*;

import java.util.Optional;

import racinggame.domain.CarNames;
import racinggame.domain.InputCount;
import racinggame.domain.Racing;
import racinggame.domain.RacingResults;
import racinggame.domain.TryCount;
import racinggame.view.GameView;

/**
 * 컨트롤러 역할을 하는 개최팀 클래스
 *
 * @author Lee JungHo <jparangdev@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Host {

	Racing racing;
	InputCount inputCount;

	public Host() {
		racing = new Racing();
		inputCount = new InputCount();
	}

	public Racing getRacing() {
		return racing;
	}

	/**
	 * 입력받은 문자열로 자동차이름들 생성후 레이싱 객체에 전달
	 */
	public void setRacingCars() {
		Optional<CarNames> carNames = Optional.empty();
		while (!carNames.isPresent() && inputCount.isPossible()) {
			String input = GameView.inputCarNames();
			carNames = Optional.ofNullable(inputCarNames(input));
			inputCount.plus();
		}
		carNames.ifPresent(cn -> racing.joinList(cn));
	}

	/**
	 * 입력받은 문자열로 자동차이름들 생성후 반환
	 *
	 * @param input 입력받은 문자열
	 * @return 자동차이름들 객체, 에러 발생시 널 반환
	 */
	private CarNames inputCarNames(String input) {
		try {
			return new CarNames(input);
		} catch (Exception e) {
			GameView.outError(e.getMessage());
			return null;
		}
	}

	/**
	 * 입력받은 문자열로 시도 회수 생성후 레이싱 객체에 전달
	 */
	public void setTryCount() {
		Optional<TryCount> tryCount = Optional.empty();
		while (!tryCount.isPresent() && inputCount.isPossible()) {
			String input = GameView.inputTryCount();
			tryCount = Optional.ofNullable(inputTryCount(input));
			inputCount.plus();
		}
		tryCount.ifPresent(tc -> racing.setTryCount(tc));
	}

	/**
	 * 입력받은 문자열로 시도회수 생성후 반환
	 *
	 * @param input 입력받은 문자열
	 * @return 시도회수 객체, 에러 발생시 널 반환
	 */
	private TryCount inputTryCount(String input) {
		try {
			return new TryCount(input);
		} catch (Exception e) {
			GameView.outError(e.getMessage());
			return null;
		}
	}

	/**
	 * 입력횟수가 최대인 경우 레이싱 비진행
	 */
	private boolean isMaxInputCount() {
		if (!inputCount.isPossible()) {
			GameView.outError(ERROR_TO_MANY_INPUT);
			return true;
		}
		return false;
	}

	/**
	 * 레이싱 시작 및 결과 반환
	 */
	public void start() {
		RacingResults racingResults = racing.startRacing();
		GameView.outRacingResult(racingResults + NEW_LINE);
		getWinner();
	}

	/**
	 * 우승자 반환
	 */
	public void getWinner() {
		GameView.outWinner(racing.getWinners().toString());
	}

	/**
	 * 프로그램 진행
	 */
	public void run() {
		setRacingCars();
		setTryCount();
		if (!isMaxInputCount()) {
			start();
		}
	}

}
