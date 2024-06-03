package racingcar;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = scanner.nextLine();
        String[] carNames = input.split(",");

        if (carNames.length == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }
        for (String name : carNames) {
            if (name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
            }
        }

        return carNames;
    }

    public int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount;
        try {
            tryCount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다.");
        }
        if (tryCount <= 0) {
            throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
        }
        return tryCount;
    }
}
