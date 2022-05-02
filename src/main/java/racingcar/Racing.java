package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Racing {

    public static int NUMBER_MOVE = 3;
    public static final String INPUT_TRY_MSG = "시도할 회수";

    public static int inputTry() {
        System.out.println(INPUT_TRY_MSG);
        return Integer.parseInt(Console.readLine());
    }

    public static String moveCar(int countAttempt) {
        String result = "";
        for(int i = 0; i < countAttempt; i++){
            int radomsResult = Randoms.pickNumberInRange(1, 9);
            result += (radomsResult > NUMBER_MOVE) ? "-":"";
        }
        return result;
    }

    public static String setWinner(String[] players, String[] result) {
        String winners = "";
        String check = "";
        for(int i = 0; i < players.length; i++){
            if(result[i].length() > check.length()) {
                winners = players[i];
                check = result[i];
            } else if(result[i].length() == check.length()){
                winners += "," + players[i];
            }
        }
        return winners;
    }
}
