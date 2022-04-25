package racingcar.view;

import racingcar.model.Message;

public class RacingGameUi {
    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printNameInputMsg(){
        System.out.println(Message.CAR_NAME_INPUT);
    }

    public static void printLapsInputMsg(){
        System.out.println(Message.RACING_LAPS_INPUT);
    }

    public static void printRacingResultMsg() {
        System.out.println(Message.RACING_RESULT_MSG);
    }

    public static void printCarNameAndPosition(String name, int pos) {
        System.out.print(name);
        System.out.print(Message.NAME_AND_POS_SEPARATOR);
        for(int i=0;i<pos;i++){
            System.out.print(Message.CAR_POSITION_CHAR);
        }
        printEmptyLine();
    }

    public static void printWinner(String name){
        System.out.print(Message.RACING_WINNER_MSG);
        System.out.println(name);
    }
}
