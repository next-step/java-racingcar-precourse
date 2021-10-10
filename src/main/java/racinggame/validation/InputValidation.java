package racinggame.validation;

import java.util.Objects;

public abstract class InputValidation {

	protected static final String EMPTY_MESSAGE = "";
	protected static final String REGEX = ",";

	protected boolean errorStatus;
	protected final String message;

	public InputValidation() {
		this.errorStatus = false;
		this.message = EMPTY_MESSAGE;
	}

	public InputValidation(boolean errorStatus, String message) {
		this.errorStatus = errorStatus;
		this.message = message;
	}

	public boolean isEmptyOrIsNull(String inputValue) {
		if (inputValue == null || inputValue.isEmpty()) {
			return true;
		}
		return checkEmptyByEachValue(inputValue.split(REGEX));
	}

	private boolean checkEmptyByEachValue(String[] values) {
		boolean isEmpty = false;
		for (String value : values) {
			isEmpty = checkEmptyByValue(isEmpty, value);
		}
		return isEmpty;
	}

	private boolean checkEmptyByValue(boolean isEmpty, String name) {
		if (name.isEmpty()) {
			isEmpty = true;
		}
		return isEmpty;
	}

	public boolean isProblem() {
		return errorStatus;
	}

	public String getErrorMessage() {
		return message;
	}

	abstract boolean isSuitableSize(String inputValue);

	abstract InputValidation checkInputStatus(String inputValue);

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		InputValidation that = (InputValidation)o;
		return errorStatus == that.errorStatus && Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(errorStatus, message);
	}
}
