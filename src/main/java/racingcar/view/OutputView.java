package racingcar.view;

import racingcar.domain.CarInfo;
import racingcar.utils.ValidCommonConditionEnum;

import java.util.List;

public class OutputView {


    public static void printCurrentPoint(CarInfo carInfo) {
        StringBuilder currentPoint = new StringBuilder(carInfo.getName() + ValidCommonConditionEnum.RESULT_PREFIX.getValue());
        for (int j = 0; j < carInfo.getForwardCount(); j++) {
            currentPoint.append(ValidCommonConditionEnum.SCORE_VALUE.getValue());
        }
        System.out.println(currentPoint.toString());
    }

    public static void printCurrentResultMsg() {
        System.out.println(ValidCommonConditionEnum.RESULT_MSG.getValue());
    }

    public static void printWinnerMsg(List<String> winnerList) {
        System.out.println(ValidCommonConditionEnum.WINNER_MSG.getValue() + String.join(ValidCommonConditionEnum.DELIMITER.getValue(), winnerList));
    }

}
