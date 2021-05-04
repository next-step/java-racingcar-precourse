package com.racingcar.common.message;

public class Messages {

	private Messages() {
		throw new IllegalStateException("Utility class");
	}

	public static final String INVALID_INPUT_MESSAGE = "유효하지 않은 입력입니다. 다시 입력해 주세요.";
	public static final String INVALID_MOVING_SEED_MESSAGE = "레이싱 카를 움직일 때 필요한 데이터가 잘 못되었습니다.";
	public static final String JUDGE_WINNER_EXCEPTION = "우승자를 선정할 수 없습니다.";
}
