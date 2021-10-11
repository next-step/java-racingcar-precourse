package racinggame.domain.constants;

public enum Status {

    NAMING_COLON(" : "),
    FORWARD("-");

    private final String message;

    Status(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
