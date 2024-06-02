package View;

import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return scanner.nextLine().split(",");
    }

    public int getRounds() {
        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                int rounds = scanner.nextInt();

                if (rounds < 0 || rounds > 9) {
                    throw new IllegalArgumentException("입력이 올바르지 않습니다. 0에서 9 사이의 값을 입력하세요.");
                }

                if (rounds <= 3) {
                    throw new IllegalArgumentException("입력이 올바르지 않습니다. 4 이상의 값을 입력하세요.");
                }

                return rounds;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
