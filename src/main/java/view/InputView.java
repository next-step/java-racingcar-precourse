package view;

import java.util.Scanner;

public class InputView {

    private static final String DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = scanner.nextLine();
        validateBlank(carNames);
        return carNames.split(DELIMITER);
    }

    private void validateBlank(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름 목륵은 null 이거나 빈 문자열일 수 없습니다.");
        }
    }
}