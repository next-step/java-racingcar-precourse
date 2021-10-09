package racinggame.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NameValidation {

	private static final String CHECK_EMPTY_ERROR_MESSAGE = "자동차 이름이 빈값 입니다.";
	private static final String CHECK_NULL_ERROR_MESSAGE = "자동차 이름이 null 입니다.";
	private static final String CHECK_LIMIT_LENGTH_ERROR_MESSAGE = "이름의 길이는 최대 5글자 입니다.";
	private static final String CHECK_DUPLICATION_ERROR_MESSAGE = "중복되는 자동차 이름이 존재 합니다.";
	private static final String REGEX = ",";
	private static final String EMPTY_MESSAGE = "";
	private static final int LIMIT_LENGTH = 5;

	private final boolean errorStatus;
	private final String message;

	public NameValidation() {
		this.errorStatus = false;
		this.message = EMPTY_MESSAGE;
	}

	public NameValidation(boolean errorStatus, String message) {
		this.errorStatus = errorStatus;
		this.message = message;
	}

	public NameValidation checkInputStatus(String name) {
		if (isNull(name)) {
			return new NameValidation(true, CHECK_NULL_ERROR_MESSAGE);
		}
		if (isEmpty(name)) {
			return new NameValidation(true, CHECK_EMPTY_ERROR_MESSAGE);
		}
		if (isSuitableSize(name)) {
			return new NameValidation(true, CHECK_LIMIT_LENGTH_ERROR_MESSAGE);
		}
		if (isDuplication(name)) {
			return new NameValidation(true, CHECK_DUPLICATION_ERROR_MESSAGE);
		}
		return new NameValidation(false, EMPTY_MESSAGE);
	}

	private boolean isDuplication(String name) {
		String[] names = name.split(REGEX);
		return names.length != findDuplicateSize(names);
	}

	private int findDuplicateSize(String[] names) {
		Set<String> carNames = new HashSet<>(Arrays.asList(names));
		return carNames.size();
	}

	public boolean isSuitableSize(String name) {
		boolean errorStatus = false;
		String[] names = name.split(REGEX);
		for (String carName : names) {
			errorStatus = isOverLimitLength(errorStatus, carName);
		}
		return errorStatus;
	}

	private boolean isOverLimitLength(boolean errorStatus, String carName) {
		if (carName.length() > LIMIT_LENGTH) {
			return true;
		}
		return errorStatus;
	}

	public boolean isEmpty(String name) {
		String[] names = name.split(REGEX);
		if (name.isEmpty()) {
			return true;
		}
		return checkNamesEmpty(names);
	}

	private boolean checkNamesEmpty(String[] names) {
		boolean isEmpty = false;
		for (String name : names) {
			isEmpty = checkEmptyByName(isEmpty, name);
		}
		return isEmpty;
	}

	private boolean checkEmptyByName(boolean isEmpty, String name) {
		if (name.isEmpty()) {
			isEmpty = true;
		}
		return isEmpty;
	}

	public boolean isNull(String name) {
		return name == null;
	}

	public boolean isProblem() {
		return errorStatus;
	}

	public String getErrorMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		NameValidation that = (NameValidation)o;
		return errorStatus == that.errorStatus && Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(errorStatus, message);
	}

}
