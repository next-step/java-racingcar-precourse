package view;

import java.util.List;
import utils.Console;
import utils.Parser;

public class InputView {
    private static final String GET_CAR_NAME_REQUEST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GET_GAME_COUNT_REQUEST = "시도할 회수는 몇회인가요?";

    public static List<String> readCarName(){
        System.out.println(GET_CAR_NAME_REQUEST);
        return Parser.validateCarNameInput(Console.readLine());
    }


    public static int readGameCount(){
        System.out.println(GET_GAME_COUNT_REQUEST);
        return Parser.validateGameCountInput(Console.readLine());
    }

}
