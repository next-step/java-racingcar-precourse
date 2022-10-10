package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInterFace {

    private static final String CAR_NAMES_MESSAGE = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";

    private static final String TRY_CNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String getCarNames(){
        System.out.println(CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public static String getMoveCount(){
        System.out.println(TRY_CNT_MESSAGE);
        return Console.readLine();
    }

    public static void printMsg(String msg){
        System.out.println(msg);
    }
}
