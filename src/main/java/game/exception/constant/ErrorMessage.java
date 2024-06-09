package game.exception.constant;

import static game.config.constant.Rule.*;

public enum ErrorMessage {

    EXCEED_NAME_LENGTH("[ERROR] 길이 %d를 초과하여 이름을 생성할 수 없습니다!".formatted(MAX_NAME_LENGTH)),
    DUPLICATE_NAME_FOUND("[ERROR] 중복된 이름이 존재합니다!"),
    INVALID_NUMBER_INPUT("[ERROR] 숫자를 입력해주세요!"),
    INVALID_ATTEMPT_COUNT_INPUT("[ERROR] 1 이상의 숫자를 입력해주세요!"),
    EMPTY_LIST("[ERROR] 리스트가 비어 있습니다!");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
