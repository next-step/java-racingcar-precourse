package racinggame;

import nextstep.utils.Console;
import utils.RaceUtils;

public class RaceUI {

    public static final int MIN_CAR_NAME_LENGTH = 5;

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
        if (carName.length() < MIN_CAR_NAME_LENGTH) {
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
}
