package racinggame.exception;

public class ValidationException extends RuntimeException {

    public ValidationException() {
        super("[ERROR] 잘 못 입력하셨습니다.");
    }

}
