package exception;

public class DuplicatedNameException extends IllegalArgumentException {

    public DuplicatedNameException() {
        super(ErrorMessage.DUPLICATED_NAME.getMessage());
    }
}
