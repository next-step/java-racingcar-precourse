import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = getCarNames();
        int trialCount = getTrialCount();
    }

    private static List<Car> getCarNames() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String inputCarNames = scanner.nextLine();
                validateinputCarNames(inputCarNames);
                return parseCarNames(inputCarNames);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateinputCarNames(String inputCarNames) {
        if (inputCarNames.startsWith(".")
                || inputCarNames.endsWith(",")
        ) {
            throw new IllegalArgumentException("[ERROR] 올바른 입력형태가 아닙니다.");
        }
    }

    public static List<Car> parseCarNames(String input) {
        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }


    private static int getTrialCount() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                int count = Integer.parseInt(scanner.nextLine());
                validateTrialCount(count);
                return count;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public static void validateTrialCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

}
