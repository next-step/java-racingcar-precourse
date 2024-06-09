package camp.nextstep.edu;

import java.util.Scanner;

public class Input {

    private Scanner scanner;

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        while (true) {
            try {
                String carNames = scanner.nextLine();
                String[] arrCarNames = carNames.split(",");
                validateCarNames(arrCarNames);
                return arrCarNames;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }   
    }

    private void validateCarNames(String[] arrCarNames) {
        checkCarNumber(arrCarNames);

        for (String name : arrCarNames) {
            checkCarNameLength(name);
        }
    }

    private void checkCarNumber(String[] arrCarNames) {
        if (arrCarNames.length == 0) {
            throw new IllegalArgumentException("[ERROR] 1개 이상의 자동차 이름을 입력하시오.");
        }
    }

    private void checkCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하로 입력하시오.");
        }
    }
}
