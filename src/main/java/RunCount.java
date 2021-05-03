public class RunCount {
	private final Integer count;

	public RunCount(String count) {
		if (StringUtils.isEmpty(count)) {
			throw new IllegalArgumentException("횟수를 입력하지 않았습니다");
		}
		if (isNotValidNumber(count)) {
			throw new IllegalArgumentException("숫자로만 입력해주세요");
		}
		this.count = Integer.parseInt(count);
	}

	public static boolean isNull(RunCount runCount) {
		return runCount == null;
	}

	boolean isNotValidNumber(String count) {
		System.out.println(count.trim());
		return !count.matches("^[1-9]+$");
	}
}
