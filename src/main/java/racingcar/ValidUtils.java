package racingcar;

public class ValidUtils {

    public static boolean isNumber(String input){
        return input.matches("-?\\d+");
    }

    public static boolean isPlus(String gameRound) {
        int number = Integer.valueOf(gameRound);
        return number > 0 ? true : false;
    }
}
