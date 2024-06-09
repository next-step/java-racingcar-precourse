package camp.nextstep.edu.view;

import java.util.Scanner;

public class Input {

    private Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        while (true) {
            try {
                String carNames = scanner.nextLine();
                return validateCarNames(carNames);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }   
    }

    public String[] validateCarNames(String carNames) {
        carNames = carNames.replaceAll("\\s", "");
        checkCarCount(carNames);

        String[] arrCarNames = carNames.split(",");
        for (String name : arrCarNames) {
            checkCarNameLength(name);
        }

        return arrCarNames;
    }

    private void checkCarCount(String arrCarNames) {
        if (arrCarNames.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 1개 이상의 자동차 이름을 입력하시오.");
        }
    }

    private void checkCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하로 입력하시오.");
        }
    }

    public int inputMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        while (true) {
            try {
                String moveCount = scanner.nextLine();
                return validateMoveCount(moveCount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int validateMoveCount(String count) {
        int moveCount = checkNumberFormat(count);
        checkMoveCount(moveCount);
        return moveCount;
    }


    private int checkNumberFormat(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("[ERROR] 시도 횟수는 정수 형태로 입력하시오.");
        }
    }

    private void checkMoveCount(int moveCount) {
        if (moveCount < 1) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1회 이상 입력하시오.");
        }
    }

    public void endInput() {
        scanner.close();
    }
}
