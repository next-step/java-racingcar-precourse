package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_CAR_NAME_DELIMITER = ",";
    private static final String INPUT_CAR_NAME_REGEX = "^([^,]{1,5},)*[^,]{1,5}$";
    private static final String INPUT_RACE_COUNT = "시도할 회수는 몇회인가요?";
    private static final String INPUT_RACE_COUNT_REGEX = "^[1-9][0-9]*$";
    private static final String INVALID_INPUT_MESSAGE = "잘못된 입력입니다.";

    private List<String> carNames;
    private int raceCount;

    /**
     * 경기 준비: 자동차 이름, 시도할 횟수를 입력
     */
    public InputView() {
        String inputCarNames = getValidatedInputValue(INPUT_CAR_NAME, INPUT_CAR_NAME_REGEX);
        carNames = Arrays.asList(inputCarNames.split(INPUT_CAR_NAME_DELIMITER));

        String inputRaceCount = getValidatedInputValue(INPUT_RACE_COUNT, INPUT_RACE_COUNT_REGEX);
        raceCount = Integer.valueOf(inputRaceCount);
    }

    /**
     * 입력
     *
     * @param text
     * @param regexPattern
     * @return 유효한 입력값 반환
     */
    public String getValidatedInputValue(String text, String regexPattern) {
        String inputValue = inputValue(text);

        try {
            validateInputValue(inputValue, regexPattern);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidatedInputValue(text, regexPattern); // 입력 값이 유효하지 않으면 재입력
        }

        return inputValue;
    }

    /**
     * 질문에 값 입력
     *
     * @param text
     * @return
     */
    private String inputValue(String text) {
        System.out.println(text);

        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.next();

        return inputValue;
    }

    /**
     * 입력 값에 대한 유효성 검사
     *
     * @param inputValue
     * @param regexPattern
     */
    private void validateInputValue(String inputValue, String regexPattern) {
        boolean isInvalid = !inputValue.matches(regexPattern);

        if (isInvalid) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getRaceCount() {
        return raceCount;
    }

}
