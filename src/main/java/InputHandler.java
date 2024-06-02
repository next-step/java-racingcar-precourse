import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();
        boolean validInput = false;

        while (!validInput) {
            try {
                carNames = getValidCarNames();
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return carNames;
    }

    private static List<String> getValidCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();
        String[] names = input.split(",");
        List<String> carNames = new ArrayList<>();
        for (String name : names) {
            validateName(name);
            carNames.add(name.trim());
        }
        return carNames;
    }

    private static void validateName(String name) {
        if (name.trim().isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

    public static int getRounds() {
        int rounds = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                rounds = getValidRounds();
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return rounds;
    }

    private static int getValidRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        int rounds = Integer.parseInt(scanner.nextLine());
        validateRounds(rounds);
        return rounds;
    }

    private static void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 회수는 1 이상이어야 합니다.");
        }
    }
}