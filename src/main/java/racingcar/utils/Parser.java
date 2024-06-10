package racingcar.utils;

public class Parser {
    public static String[] parseCarName(String input){
        return input.split(",");
    }

    public static int parseTrialNumber(String input){
        return Integer.parseInt(input);
    }
}
