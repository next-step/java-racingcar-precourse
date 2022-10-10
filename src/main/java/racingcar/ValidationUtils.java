package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class ValidationUtils {

    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)";
    public static final String GAME_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String RACING_CAR_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름 입력 값을 잘못 입력하였습니다.";
    public static final String GAME_COUNT_ERROR_MESSAGE = "[ERROR] 게임 횟수 입력값을 잘못 입력하였습니다.";

    public static boolean validCarName(String input) {
        if (input.length() > 5 || input.length() == 0) {
            throw new IllegalArgumentException(RACING_CAR_NAME_ERROR_MESSAGE);
        }
        return true;
    }

    public static List<String> inputSplit(String carNameInput) {
        return Arrays.asList(carNameInput.split(","));
    }


    public static boolean validCarNames(List<String> carNames) {
        try {
            for (String carName : carNames) {
                validCarName(carName);
            }
        } catch (IllegalArgumentException e) {
            return errorProcess(e);
        }
        return true;
    }

    public static List<String> getCarNames() {
        boolean endFlag = true;
        List<String> carNames = null;
        while (endFlag) {
            String input = getInput(CAR_NAME_INPUT_MESSAGE);
            carNames = inputSplit(input);
            endFlag = !validCarNames(carNames);
        }
        return carNames;
    }

    public static boolean validateGameCount(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GAME_COUNT_ERROR_MESSAGE);
        }
        return true;
    }

    public static int getGameCount() {
        boolean endFlag = true;
        String input = null;
        while (endFlag) {
            try {
                input = getInput(GAME_COUNT_INPUT_MESSAGE);
                endFlag = !validateGameCount(input);
            } catch (IllegalArgumentException e) {
                endFlag = !errorProcess(e);
            }
        }
        return Integer.parseInt(input);
    }

    public static boolean errorProcess(Exception e) {
        System.out.println(e.getMessage());
        return false;
    }

    public static String getInput(String message){
        System.out.println(message);
        return Console.readLine();
    }

}
