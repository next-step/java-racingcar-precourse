package com.racingcar.common.message;

public class Messages {

	private Messages() {
		throw new IllegalStateException("Utility class");
	}

	public static final String NEW_LINE="\n";
	public static final String EMPTY="";

	public static final String INVALID_INPUT_MESSAGE = "유효하지 않은 입력입니다. 다시 입력해 주세요.";
	public static final String INVALID_MOVING_SEED_MESSAGE = "레이싱 카를 움직일 때 필요한 데이터가 잘못되었습니다.";
	public static final String JUDGE_WINNER_EXCEPTION_MESSAGE = "우승자를 선정할 수 없습니다.";
	public static final String REQUIRED_SERVICES_EXCEPTION_MESSAGE = "필수 서비스가 누락되었습니다.";
	public static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇 회인가요?";
	public static final String RACING_RESULT_MESSAGE = "실행 결과";
	public static final String JUDGE_WINNER_MESSAGE = "가 최종 우승했습니다.";

	public static String getMessageWithNewLine(String message) {
		return message + NEW_LINE;
	}
}
