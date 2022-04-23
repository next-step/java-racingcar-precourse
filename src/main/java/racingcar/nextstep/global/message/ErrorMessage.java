package racingcar.nextstep.global.message;

public interface ErrorMessage {

    String ERROR_PREFIX ="[ERROR] ";

    String NAME_EXCEED = ERROR_PREFIX + "이름은 최대 5글자 입니다.";
    String NAME_NOT_BLANK = ERROR_PREFIX + "이름은 공백일 수 없습니다.";
    String IS_NOT_NUMBER = ERROR_PREFIX + "숫자를 입력해주세요";
}
