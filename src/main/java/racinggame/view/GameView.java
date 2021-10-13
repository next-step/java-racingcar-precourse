package racinggame.view;

import static racinggame.common.ViewMessage.*;

import nextstep.utils.Console;
import racinggame.controller.Host;

/**
 * 사용자의 입력과 출력메세지를 담당하는 클래스
 *
 * @author Lee JungHo <jparangdev@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class GameView {

	/**
	 * 자동차 이름 입력
	 *
	 * @param host 레이스를 진행중인 개최팀
	 */
	public void inputName(Host host) {
		System.out.println(MESSAGE_NAME_INPUT);
		String input = Console.readLine();
		try {
			host.setRacingCars(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			inputName(host);
		}
	}

	/**
	 * 시도 회수 입력
	 *
	 * @param host 레이스를 진행중인 개최팀
	 */
	public void inputTryCount(Host host) {
		System.out.println(MESSAGE_TRY_INPUT);
		String input = Console.readLine();
		try {
			host.setTryCount(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			inputTryCount(host);
		}
	}

	/**
	 * 레이싱 결과 출력
	 *
	 * @param host 레이스를 진행중인 개최팀
	 */
	public void outRacingResult(Host host) {
		System.out.println(MESSAGE_TRY_RESULT);
		System.out.println(host.getRacingResult());
	}

	/**
	 * 우승자 출력
	 *
	 * @param host 레이스를 진행중인 개최팀
	 */
	public void outWinner(Host host) {
		System.out.printf(MESSAGE_WINNER_FORMAT, host.getWinner());
	}

	/**
	 * 프로그램 진행
	 */
	public void run() {
		Host host = new Host();
		inputName(host);
		inputTryCount(host);
		host.start();
		outRacingResult(host);
		outWinner(host);
	}
}
