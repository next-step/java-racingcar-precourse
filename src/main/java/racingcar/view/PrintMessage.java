package racingcar.view;

import racingcar.constant.RacingSystemMessage;

public class PrintMessage {

    public void printPlayCountMessage() {
        System.out.println(RacingSystemMessage.INPUT_PLAY_COUNT_MESSAGE.getMessage());
    }

    public void printRequestCarNamesMessage() {
        System.out.println(RacingSystemMessage.INPUT_RACING_CAR_NAMES.getMessage());
    }

    public String printFinalVictoryCarName(){
        return RacingSystemMessage.OUTPUT_VICTORY_CAR.getMessage();
    }

    public void printExcuteResultMessage(){
        System.out.println(RacingSystemMessage.OUTPUT_RESULT_INFO.getMessage());
    }
}
