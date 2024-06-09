package view;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public String[] inputCarNames() {
        String[] carNames = null;
        boolean isValid = false;

        while(!isValid) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNames = scanner.nextLine().split(",");

            isValid = isValidCarNames(carNames);
        }

        return carNames;
    }

    private boolean isValidCarNames(String[] carNames) {
        for (String carName : carNames) {
            if(!isValidCarName(carName)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidCarName(String carName) {
        try {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 입력이 가능합니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return false;
        }
        return true;
    }

}
