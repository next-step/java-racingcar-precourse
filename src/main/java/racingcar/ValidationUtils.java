package racingcar;

public class ValidationUtils {

    private static final String CAR_REGEX = ",";
    private static final String CNT_REGEX = "[0-9]+";
    public static final String ERROR_MESSAGE = "[ERROR] ";

    public static final int BOUNDARY_NUM = 4;
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;

    private static final int LIMIT_LENGTH = 5;

    public static String[] validateCarNames(String[] carNames) throws IllegalArgumentException {
        for(String carName : carNames){
            isValidCarName(carName);
        }
        return carNames;
    }

    private static void isValidCarName(String carName) throws IllegalArgumentException {
        if(carName.length() > LIMIT_LENGTH) throw new IllegalArgumentException(ERROR_MESSAGE + LIMIT_LENGTH + MessageUtils.VALIDATE_NAME.getMessage());
    }

    public static int isValidCnt(String inputTryCnt) throws IllegalArgumentException {
        if(!inputTryCnt.matches(CNT_REGEX)) throw new IllegalArgumentException(ERROR_MESSAGE + MessageUtils.VALIDATE_CNT.getMessage());
        return Integer.parseInt(inputTryCnt);
    }

    public static String[] makeSplitedArray(String inputCarNames) {
        return inputCarNames.split(CAR_REGEX);
    }

    public static boolean isValidNum(int result) {
        return result >= MIN_NUMBER && result <= MAX_NUMBER;
    }
}
