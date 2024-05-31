import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingGameView {
    private final Scanner scanner=new Scanner(System.in);

    public List<String> getCarNames() {
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String input = scanner.nextLine();
                List<String> carNames = Arrays.asList(input.split(","));
                errorCarNames(carNames);
                return carNames;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getMoveCount(Scanner scanner) {
        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                int moveCount = Integer.parseInt(scanner.nextLine());
                System.out.println();
                return moveCount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력하세요.");
            }
        }
    }

    public void printProgress(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinner(List<Car> winner) {
        String winnerName = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자: " + winnerName);
    }

    private static void errorCarNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : carNames) {
            String trimmedName = name.trim();
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
            }
            if (name.contains(" ")) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름에 공백을 포함할 수 없습니다.");
            }
            if (!uniqueNames.add(trimmedName)) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
            }
        }
    }
}
