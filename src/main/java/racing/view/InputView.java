package racing.view;

import java.util.Scanner;

/**
 * 사용자 입력을 처리하는 클래스.
 */
public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String[] getCarNames() {
        while (true) {
            try {
                System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 기준으로 구분\n");
                String[] carNames = scanner.nextLine().split(",");
                validateCarNames(carNames);
                return carNames;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public int getRounds() {
        while (true) {
            try {
                System.out.print("시도할 회수는 몇회인가요?\n ");
                int rounds = Integer.parseInt(scanner.nextLine());
                validateRounds(rounds);
                return rounds;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
