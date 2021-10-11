package racinggame;

import nextstep.utils.Console;
import utils.RaceUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RaceUI {

    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final String KEY_POSITION_DELIMETER = " : " ;
    public static final String COMMA = "," ;
    public static final String POSITION_PRESENTING_CHARACTER = "-" ;

    private RaceUI() {
    }

    public static String[] takeCarNameInputProcess() {
        printAskingCarNameMessage();
        String[] carNames = takeCarNamesInput();
        try {
            validateCarNameInput(carNames);
        } catch (RaceException e) {
            printInvalidInputMessage(e.getMessage());
            takeCarNameInputProcess();
        }
        return carNames;
    }

    private static String[] takeCarNamesInput() {
        String input = Console.readLine();
        return RaceUtils.splitStringByComma(input);
    }

    private static void printInvalidInputMessage(String message) {
        System.out.println(message);
    }

    protected static void validateCarNameInput(String[] input) throws RaceException {
        for (String carName : input) {
            checkLength(carName);
        }
    }

    private static void checkLength(String carName) throws RaceException {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new RaceException(RaceErrorCode.INVALID_CAR_NAME_LENGTH);
        }
    }

    private static void printAskingCarNameMessage() {
        System.out.println(RaceMessages.ASK_CAR_NAMES.message());
    }

    public static int takeIterationCountProcess() {
        printAskingIterationCountMessage();
        String countInput = takeIterationCountInput();
        try {
            validateIterationCountInput(countInput);
        } catch (RaceException e) {
            printInvalidInputMessage(e.getMessage());
            takeIterationCountProcess();
        }
        return Integer.parseInt(countInput);
    }

    protected static void validateIterationCountInput(String countInput) {
        checkNumberFormat(countInput);
        checkInputRange(countInput);
    }

    private static void checkInputRange(String countInput) {
        if (Integer.parseInt(countInput) <= 0) {
            throw new RaceException(RaceErrorCode.INVALID_FORMAT_ITERATION_COUNT);
        }
    }

    private static void checkNumberFormat(String countInput) {
        try {
            Integer.parseInt(countInput);
        } catch (NumberFormatException e) {
            throw new RaceException(RaceErrorCode.INVALID_FORMAT_ITERATION_COUNT);
        }
    }

    private static String takeIterationCountInput() {
        return Console.readLine();
    }

    private static void printAskingIterationCountMessage() {
        System.out.println(RaceMessages.ASK_ITERATION_COUNT.message());
    }

    public static void printCurrentRaceStatus(Map<String, Integer> namePositionMap) {
        for (String key: namePositionMap.keySet()) {
            StringBuffer sb = new StringBuffer();
            sb.append(key + KEY_POSITION_DELIMETER);
            for (int i = 0; i < namePositionMap.get(key); i++) {
                sb.append(POSITION_PRESENTING_CHARACTER);
            }
            System.out.println(sb);
        }
        System.out.println();
    }

    public static void printWinnerNames(List<Car> winners) {
        String joinedName = getCommaJoinedWinnerName(winners);
        System.out.println(
                RaceMessages.PRINT_WINNER_PREFIX.message() + joinedName + RaceMessages.PRINT_WINNER_POSTFIX.message()
        );
    }

    private static String getCommaJoinedWinnerName(List<Car> winners) {
        List<String> nameList = new ArrayList<>();
        for (Car winner : winners) {
            nameList.add(winner.getCarName());
        }
        return String.join(COMMA, nameList);
    }
}
