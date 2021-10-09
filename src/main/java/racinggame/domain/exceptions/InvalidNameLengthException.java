package racinggame.domain.exceptions;

public class InvalidNameLengthException extends BusinessException {

    public InvalidNameLengthException() {
        super("이름은 다섯 글자를 넘을 수 없습니다.");
    }
}
