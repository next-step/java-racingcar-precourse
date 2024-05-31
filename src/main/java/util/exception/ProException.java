package util.exception;

public class ProException extends IllegalArgumentException {
    private static final String PREFIX = "[ERROR] ";

    private ProException(ProMessage proMessage) {
        super(PREFIX + proMessage.getMessage());
    }

    public static ProException from(ProMessage proMessage) {
        return new ProException(proMessage);
    }
}