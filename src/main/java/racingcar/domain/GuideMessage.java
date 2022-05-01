package racingcar.domain;

public enum GuideMessage {
    자동차이름_입력안내("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)"),
    진행_횟수_입력안내("시도할 횟수"),
    우승자_안내("최종 우승자: "),
    에러_자동차이름("[ERROR] 자동차 이름은 5자 이하만 가능합니다."),
    에러_올바른_횟수("[ERROR] 시도 횟수는 숫자여야 합니다."),
    에러_올바른_횟수_음수("[ERROR] 시도 횟수는 0보다 커야 합니다.");

    private String message;

    GuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void printlnMessage() {
        System.out.println(this.message);
    }

    public void printMessage() {
        System.out.print(this.message);
    }

}
