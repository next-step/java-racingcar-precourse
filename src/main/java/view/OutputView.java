package view;

import vo.Car;

import java.util.Collections;
import java.util.List;

public class OutputView {

    private final static String ASK_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String ASK_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static String DISTANCE = "-";
    private final static String FINAL_WINNER = "최종 우승자: ";

    public void askCarNameMessage() {
        System.out.println(ASK_CAR_NAME_MESSAGE);
    }

    public void askTryCountMessage() {
        System.out.println(ASK_TRY_COUNT_MESSAGE);
    }

}
