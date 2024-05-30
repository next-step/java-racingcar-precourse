package exception;

public class NameLengthException extends IllegalArgumentException{

    public NameLengthException() {
        super(ErrorMessage.NAME_LENGTH_MORE_THAN_FIVE.getMessage());
    }
}
