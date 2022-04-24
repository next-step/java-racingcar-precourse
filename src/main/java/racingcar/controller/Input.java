package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {

    public static String inputCarNames(){
        return readLine();
    }

    public static Integer inputTurns(){
        String number = readLine();
        isNumeric(number);
        Integer turns = Integer.parseInt(number);
        return turns;
    }

    private static void isNumeric(String input) {
        if(input == null){
            throw new IllegalArgumentException("[ERROR] input is null");
        }
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException nfe){
            throw new IllegalArgumentException("[ERROR] input is not numeric");
        }
    }
}
