package view;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import utils.Console;

public class InputView {
    private static final String GET_CAR_NAME_REQUEST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GET_GAME_COUNT_REQUEST = "시도할 회수는 몇회인가요?";

    public static List<String> readCarName(){
        List<String> validCarName = null;
        do {
            System.out.println(GET_CAR_NAME_REQUEST);
            try{
                validCarName = Parser.validateCarNameInput(Console.readLine());
            }catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }while (validCarName == null);

        return validCarName;
    }


    public static int readGameCount(){
        Integer validGameCount = null;
        do {
            System.out.println(GET_GAME_COUNT_REQUEST);
            try {
                validGameCount = Parser.validateGameCountInput(Console.readLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (validGameCount == null);

        return validGameCount;
    }

}
