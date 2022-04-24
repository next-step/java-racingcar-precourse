package racingcar.constants;

public enum ProcessIndicator {
    INIT("초기상태"), CAR_SET("자동차 생성 완료 상태"), COUNT_SET("횟수 세팅 완료 상태");
    final String state;

    ProcessIndicator(final String state) {
        this.state = state;
    }
}
