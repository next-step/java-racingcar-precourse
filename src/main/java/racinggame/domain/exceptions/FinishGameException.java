package racinggame.domain.exceptions;

public class FinishGameException extends BusinessException {

    public FinishGameException() {
        super("게임이 종료되었습니다.");
    }
}
