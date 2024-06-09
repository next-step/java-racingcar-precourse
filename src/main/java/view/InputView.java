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
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            String input = br.readLine();
            List<String> carNames = parseCarNames(input);
            validateCarNames(carNames);
            return carNames;
        } catch (IOException e) {
            throw new IllegalStateException("[ERROR] 입력을 읽는 중 오류가 발생했습니다.", e);
        }
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
}
