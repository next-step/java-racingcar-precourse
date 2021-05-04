public class RunCount {
	private final Integer count;

	public RunCount(String count) {
		StringUtils.validateEmptyString(count);
		if (isNotValidNumber(count)) {
			throw new IllegalArgumentException("1 이상의 알맞은 숫자로만 입력해주세요");
		}
		this.count = Integer.parseInt(count);
	}

	public Integer get() {
		return this.count;
	}

	public static boolean isNull(RunCount runCount) {
		return runCount == null;
	}

	boolean isNotValidNumber(String count) {
		return !count.matches("^[1-9][0-9]*$");
	}
}
