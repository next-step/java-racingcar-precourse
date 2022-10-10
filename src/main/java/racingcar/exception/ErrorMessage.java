package racingcar.exception;

public enum ErrorMessage {
    INVALID_CAR_NAME_NULL("The car name cannot be null"),
    INVALID_CAR_NAME_LENGTH("Check the length of the car name"),
    INVALID_CAR_NAME_EMPTY("The car name cannot be empty"),
    INVALID_CAR_LIST_SIZE("Please check the number of cars for the racing game"),
    INVALID_INPUT_ROUND("Check the input value or type");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getValue() {
        return "[ERROR] " + this.errorMessage;
    }
}
