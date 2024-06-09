package game.exception.constant;

import static game.config.constant.Rule.*;

public enum ErrorMessage {

    INVALID_NAME_LENGTH("[ERROR] %d ~ %d 글자를 벗어난 이름이 존재합니다!".formatted(MIN_NAME_LENGTH, MAX_NAME_LENGTH)),
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
