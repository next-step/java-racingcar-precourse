package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> getCarNames() {
        while (true) {
            try {
                OutputView.printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String input = br.readLine();
                List<String> carNames = parseCarNames(input);
                validateCarNames(carNames);
                return carNames;
            } catch (IOException e) {
                handleInputError("[ERROR] 입력을 읽는 중 오류가 발생했습니다. 다시 시도해주세요.");
            } catch (IllegalArgumentException e) {
                handleInputError(e.getMessage());
            }
        }
    }

    public static int getRaceCount() {
        while (true) {
            try {
                OutputView.printMessage("시도할 횟수는 몇회인가요?");
                String input = br.readLine();
                return validateRaceCount(input);
            } catch (IOException e) {
                handleInputError("[ERROR] 입력을 읽는 중 오류가 발생했습니다. 다시 시도해주세요.");
            } catch (IllegalArgumentException e) {
                handleInputError(e.getMessage());
            }
        }
    }

    private static void handleInputError(String message) {
        OutputView.printMessage(message);
    }

    private static List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
    }

    private static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        }
    }

    private static int validateRaceCount(String input) {
        try {
            int raceCount = Integer.parseInt(input);
            if (raceCount <= 0) {
                throw new IllegalArgumentException("[ERROR] 경주 횟수는 1 이상이어야 합니다.");
            }
            return raceCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력하세요.");
        }
    }
}
