import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();
        String[] names = input.split(",");
        for (String name : names) {
            if (name.trim().isEmpty() || name.trim().length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.");
            }
        }
        return List.of(names);
    }

    public static int getRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        int rounds = Integer.parseInt(scanner.nextLine());
        if (rounds <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 회수는 1 이상이어야 합니다.");
        }
        return rounds;
    }
}