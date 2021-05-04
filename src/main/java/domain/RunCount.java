package domain;

import util.StringUtils;

public class RunCount {
	private final Integer count;
	private final String NUMBER_REGEX_PATTERN = "^[1-9][0-9]*$";

	public RunCount(String count) {
		StringUtils.validateEmptyString(count);
		if (isNotValidNumber(count)) {
			throw new IllegalArgumentException("1 이상의 알맞은 숫자로만 입력해주세요");
		}
		this.count = Integer.parseInt(count);
	}

	public static boolean isNull(RunCount runCount) {
		return runCount == null;
	}

	public Integer get() {
		return this.count;
	}

	public boolean isNotValidNumber(String count) {
		return !count.matches(NUMBER_REGEX_PATTERN);
	}
}
