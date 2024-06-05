package game.exception.constant;

import static game.config.constant.Rule.*;

public enum ErrorMessage {

    EXCEED_NAME_LENGTH("길이 %d를 초과하여 이름을 생성할 수 없습니다!".formatted(MAX_NAME_LENGTH));

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
