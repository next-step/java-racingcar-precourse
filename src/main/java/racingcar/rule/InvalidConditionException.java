package racingcar.rule;

final class InvalidConditionException extends RuntimeException {

    InvalidConditionException() {
        super("전진 조건에 대한 값이 올바르지 않습니다.");
    }
}
