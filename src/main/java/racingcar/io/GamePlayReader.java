package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import racingcar.car.domain.models.CarName;
import racingcar.util.StringUtils;

public class GamePlayReader {

    private static final String INPUT_CAR_NAME_EMPTY_ERROR = "[ERROR] 자동차들의 이름은 비어있을 수 없습니다.";
    private static final String INPUT_CAR_NAME_LENGTH_ERROR =
            "[ERROR] 자동차들의 이름은 " + CarName.MAX_CAR_NAME_LENGTH + " 보다 작아야합니다.";
    private static final String INPUT_CAR_NAME_DUPLICATE_ERROR = "[ERROR] 자동차들의 이름은 중복이 있을 수 없습니다.";

    private static final String INPUT_TRY_COUNT_NOT_NUMBER_ERROR = "[ERROR] 시도할회수는 숫자형태이며, 양수여야합니다.";

    private static final String INPUT_TRY_COUNT_VALID_REGEX = "^\\d+$";

    private GamePlayReader() {
    }

    public static List<String> readPlayerNameInput() {
        try {
            String playerNameInput = Console.readLine();
            validatePlayerNameInput(playerNameInput);

            return Arrays.asList(splitByComma(playerNameInput));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPlayerNameInput();
        }
    }

    public static int readPlayerTryCount() {
        try {
            String playerTryCount = Console.readLine();
            validatePlayerTryCount(playerTryCount);

            return Integer.parseInt(playerTryCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPlayerTryCount();
        }
    }

    private static void validatePlayerNameInput(String playerNameInput) {
        validatePlayerNameIsEmpty(playerNameInput);
        validatePlayerNameFormat(splitByComma(playerNameInput));
        validateDuplicate(splitByComma(playerNameInput));
    }

    private static void validateDuplicate(String[] names) {
        HashSet<String> unDuplicatedNames = new HashSet<>(Arrays.asList(names));
        if (names.length != unDuplicatedNames.size()) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_DUPLICATE_ERROR);
        }
    }

    private static void validatePlayerNameIsEmpty(String playerNameInput) {
        if (playerNameInput == null || playerNameInput.isEmpty()) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_EMPTY_ERROR);
        }
    }

    private static void validatePlayerNameFormat(String[] names) {
        if (names.length == 0) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_EMPTY_ERROR);
        }
        for (String name : names) {
            validateName(name);
        }
    }

    private static void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_EMPTY_ERROR);
        }
        if (name.length() > CarName.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_LENGTH_ERROR);
        }
    }

    private static void validatePlayerTryCount(String playerTryCount) {
        if (!playerTryCount.matches(INPUT_TRY_COUNT_VALID_REGEX)) {
            throw new IllegalArgumentException(INPUT_TRY_COUNT_NOT_NUMBER_ERROR);
        }
    }

    private static String[] splitByComma(String playerNameInput) {
        return playerNameInput.split(StringUtils.COMMA);
    }
}
