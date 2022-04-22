package racingcar.view;

import racingcar.model.Name;

public class ResultView {

    public final static String INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public final static String INPUT_TRY_NUMBER = "시도할 회수는 몇 회 인가요?";
    public final static String RESULT_TITLE = "실행 결과";
    public final static String RESULT_MOVE_MARK = "%s : %s";
    public final static String RESULT_FINAL_WINNER = "최종 우승자: %s";
    public final static String MARK = "-";

    public final static String ERROR_NAME_BLANK = "[ERROR] 이름을 입력해주세요.";
    public final static String ERROR_NAME_MAX_SIZE = String.format("[ERROR] 자동차 이름은 %d자 이하만 가능합니다.", Name.MAX_SIZE);
    public final static String ERROR_NOT_INTEGER = "[ERROR] 값이 올바르지 않습니다. 0보다 큰 숫자 값을 입력 해주세요";

    public static void getInputCarsNameMessage(){
        System.out.println(INPUT_CARS_NAME);
    }

    public static void getInputTryNumberMessage(){
        System.out.println(INPUT_TRY_NUMBER);
    }

    public static void getResultTitleMessage(){
        System.out.println(RESULT_TITLE);
    }

    public static void getResultMoveMarkMessage(String name, String mark){
        System.out.println(String.format(RESULT_MOVE_MARK, name, mark));
    }

    public static void getResultFinalWinnerMessage(String winner){
        System.out.println(String.format(RESULT_FINAL_WINNER, winner));
    }

    public static void getPrintMessage(String message) {
        System.out.println(message);
    }
}
