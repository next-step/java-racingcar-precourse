package racingcar.code;

public enum Message {

  ERROR_INPUT_BLANK("[ERROR] 자동차 이름은 필수입니다."),
  ERROR_NAME_LENGTH("[ERROR] 자동차 이름은 5자 이하로 입력해야합니다."),
  FIRST_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은쉼표(,) 기준으로 구분)"),
  ROUND_COUNT_MESSAGE("시도할 회수는 몇회인가요?"),
  ROUND_END_MESSAGE("실행 결과"),
  WINNER_MESSAGE("최종 우승자"),
  ;

  private String msg;
  Message(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return this.msg;
  }

  public String getWinner(String winner) {
    return String.format("%s : %s", this.WINNER_MESSAGE.getMsg(), winner);
  }
}
