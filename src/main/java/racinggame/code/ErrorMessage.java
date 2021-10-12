package racinggame.code;

public enum ErrorMessage {
    INVALID_CAR_NAME_LENGTH("Check the length of the car name"),
    INVALID_CAR_NAME_NULL("The car name cannot be null"),
    INVALID_CAR_LIST_SIZE("Please check the number of cars for the racing game");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getValue() {
        return "[ERROR] " + this.errorMessage;
    }
}
