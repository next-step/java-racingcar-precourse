package racinggame.view;

import nextstep.utils.Console;
import racinggame.domain.Cars;

public class InputView {
    public Cars inputCarName() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            String carNamesInput = Console.readLine();
            validateCarNamesString(carNamesInput);
            return new Cars(splitCarNamesString(carNamesInput));
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return inputCarName();
        }
    }

    private void validateCarNamesString(String carNamesInput) {
        if (carNamesInput.trim().length() == 0) {
            throw new IllegalArgumentException("[ERROR] 이름들을 쉼표(,)로 구분하여 입력해주세요.");
        }
    }

    private String[] splitCarNamesString(String carNamesString) {
        return carNamesString.split(",");
    }

    public int inputLabCount() {
        try {
            System.out.println("시도할 횟수는 몇 회 인가요?");
            return parseLabCountStringToInt(Console.readLine());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return inputLabCount();
        }
    }

    private int parseLabCountStringToInt(String labCountString) {
        try {
            int labCount = Integer.parseInt(labCountString);
            validateLabCount(labCount);
            return labCount;
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    private void validateLabCount(int labCount) {
        if (labCount <= 0) {
            throw new IllegalArgumentException("[ERROR] 0보다 큰 숫자를 입력해주세요.");
        }
    }
}
