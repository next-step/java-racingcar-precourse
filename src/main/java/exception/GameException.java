package exception;

import constant.GameErrorCode;

public class GameException extends RuntimeException {
    GameErrorCode gameErrorCode;

    GameException() {
        super();
    }

    public GameException(String msg) {
        super(msg);
    }

    public GameException(GameErrorCode gameErrorCode) {
        super(gameErrorCode.getMsg());
        this.gameErrorCode = gameErrorCode;
    }

    public GameException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public GameErrorCode getGameErrorCode() {
        return gameErrorCode;
    }

}
