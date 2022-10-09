package racingcar.constant;

public enum ErrorCode {

    자동차_이름은_5자_이하("[ERROR] 자동차 이름은 5자 이하여야 합니다."),
    자동차_이름은_비어있을_수_없음("[ERROR] 자동차 이름은 비어있을 수 없습니다(입력 첫 자리는 쉼표(,)일 수 없으며, 마지막 자리에는 쉼표(,) 올 수 있음)."),
    유효한_자동차_이름_없음("[ERROR] 유요한 자동차 이름이 없습니다."),
    자동차_이름_중복("[ERROR] 자동차 이름은 중복될 수 없습니다."),
    RACING_TIME만큼_숫자가_생성되지_않음("[ERROR] 전진하는 조건 횟수만큼 숫자가 생성되지 않았습니다."),
    전진하는_조건은_0과_9_사이_값("[ERROR] 전진하는 조건은 0과 9 사이의 값이어야 합니다."),
    입력받은_레이싱_시도_횟수는_숫자("[ERROR] 레이싱 시도 횟수는 1 이상의 숫자만 올 수 있습니다."),
    레이싱을_시도할_횟수는_0보다_큰_양수("[ERROR] 레이싱을 시도할 횟수는 0보다 큰 양의 정수여야 합니다."),
    RACING_TIME만큼_숫자를_입력하지_않음("[ERROR] 전진하는 조건 횟수만큼 숫자를 입력하지 않았습니다."),
    각_차수별_전진하는_조건은("[ERROR] 각 차수별 전진하는 조건은 "),
    보다_작을_수_없음("보다 작을 수 없습니다."),
    보다_클_수_없음("보다 클 수 없습니다."),
    ;

    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
