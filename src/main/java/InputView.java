import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public List<String> getCarNames() {
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String input = scanner.nextLine();
                return parseCarNames(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getTryCount() {
        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                String input = scanner.nextLine();
                return parseTryCount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<String> parseCarNames(String input) {
        List<String> names = Arrays.asList(input.split(","));
        if (names.isEmpty() || names.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
        }
        return names;
    }

    public int parseTryCount(String input) {
        try {
            int tryCount = Integer.parseInt(input);
            if (tryCount <= 0) {
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
            }
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력하세요.");
        }
    }
}
