package camp.nextstep.edu;

import java.util.Scanner;
import java.util.stream.Stream;

public class UI {

    private final Scanner scanner;
    private String[] carNames;

    public UI(Scanner scanner) {
        this.scanner = scanner;
    }

    public void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        while (true) {
            String carNames = scanner.nextLine();
            try {
                this.carNames = checkCarNames(carNames);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String[] checkCarNames(String carNames) throws IllegalArgumentException {
        String[] arrNames = carNames.split(",");
        long cnt = Stream.of(arrNames)
                .map(String::trim)
                .filter(this::carNameLengthCheck)
                .count();
        if (cnt == arrNames.length) {
            return arrNames;
        }
        throw new IllegalArgumentException("[ERROR] 경주할 자동차 이름 형식을 확인 하세요.");
    }

    private boolean carNameLengthCheck(String s) {
        return !s.isEmpty() && s.length() <= 5;
    }
}
