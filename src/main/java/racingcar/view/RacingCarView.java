package racingcar.view;

import racingcar.domain.racing.result.Result;

public interface RacingCarView {

    String READ_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    String READ_TRY_NO = "시도할 회수는 몇회인가요?";
    String RESULT_HEADER = "\n실행 결과";

    String readLine(String question);

    void printResult(Result result);
}
