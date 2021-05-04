package com.racingcar.input;

public class TryCount {
	private Integer value;

	public TryCount(String strValue) {
		try {
			value = Integer.valueOf(strValue);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("시도 횟수는 숫자만 입력해야 합니다.");
		}
	}

	public Integer getValue() {
		return value;
	}
}
