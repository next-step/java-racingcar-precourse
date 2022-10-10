package racingcar.model;

import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;

public class Progress implements Comparable<Progress> {
	private static final String BAR_CHARACTER = "-";
	private static final int PROGRESS_MIN = 0;
	private static final int RANDOM_RANGE_START = 0;
	private static final int RANDOM_RANGE_END = 9;
	private static final int FORWARD_CONDITION = 4;
	private static final int FORWARD_PROGRESS = 1;
	private final int value;

	private Progress(int value) {
		validate(value);
		this.value = value;
	}

	public static Progress begin() {
		return new Progress(PROGRESS_MIN);
	}

	public static Progress from(int progress) {
		return new Progress(progress);
	}

	private void validate(int progress) {
		if (progress < PROGRESS_MIN) {
			throw new IllegalArgumentException("진행도는 0보다 작을 수 없습니다.");
		}
	}

	public int getValue() {
		return value;
	}

	public Progress tryForward() {
		int random = Randoms.pickNumberInRange(RANDOM_RANGE_START, RANDOM_RANGE_END);
		if (random >= FORWARD_CONDITION) {
			return new Progress(this.value + FORWARD_PROGRESS);
		}
		return this;
	}

	public String getProgressBar() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < value; i++) {
			stringBuilder.append(BAR_CHARACTER);
		}
		return stringBuilder.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Progress progress = (Progress)o;
		return getValue() == progress.getValue();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getValue());
	}

	@Override
	public int compareTo(Progress other) {
		if (this.getValue() > other.getValue()) {
			return 1;
		}
		if (this.getValue() < other.getValue()) {
			return -1;
		}
		return 0;
	}
}
