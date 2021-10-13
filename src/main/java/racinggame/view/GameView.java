package racinggame.view;

import static racinggame.common.ErrorMessage.*;
import static racinggame.common.ViewMessage.*;

import nextstep.utils.Console;

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
	 * @return 입력받은 문자열
	 */
	public static String inputCarNames() {
		System.out.println(MESSAGE_NAME_INPUT);
		return Console.readLine();
	}

	/**
	 * 시도 회수 입력
	 *
	 * @return 입력받은 문자열
	 */
	public static String inputTryCount() {
		System.out.println(MESSAGE_TRY_INPUT);
		return Console.readLine();
	}

	/**
	 * 레이싱 결과 출력
	 *
	 * @param results 레이싱 결과 문자열
	 */
	public static void outRacingResult(String results) {
		System.out.println(MESSAGE_TRY_RESULT);
		System.out.println(results);
	}

	/**
	 * 우승자 출력
	 *
	 * @param result 우승자 이름
	 */
	public static void outWinner(String result) {
		System.out.printf(MESSAGE_WINNER_FORMAT, result);
	}

	/**
	 * 에러 출력
	 *
	 * @param message 에러 메시지
	 */
	public static void outError(String message) {
		System.out.println(ERROR_PREFIX + message);
	}
}
