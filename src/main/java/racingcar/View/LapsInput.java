package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class LapsInput {
    private static final String LABS_INPUT_GUIDE_MESSAGE = "시도할 회수는 몇회인가요? ";
    private static final String WHITESPACE_MESSAGE = "[ERROR] 공백만 입력하면 안됩니다.";
    private static final String INVALID_NUMBER_MESSAGE = "[ERROR] 숫자만 입력해야 합니다.";

    public static int input() {
        View.println(LABS_INPUT_GUIDE_MESSAGE);
        String labs = Console.readLine();
        try{
            validate(labs);
        } catch(IllegalArgumentException e){
            View.println("다시 입력하세요.");
            input();
        }
        return Integer.parseInt(labs);
    }

    private static void validate(String labs) {
        if (labs.trim().isEmpty()){
            throw new IllegalArgumentException(WHITESPACE_MESSAGE);
        }
        try {
            Integer.parseInt(labs);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INVALID_NUMBER_MESSAGE);
        }
    }
}
