import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static final String SET_CAR_NAMES = "경주할 자동차의 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String QUESTION_MOVE_NUM = "시도할 회수는 몇회인가요?";

    public static void main(String[] args) {
        List<String> carNames = setCarNames();
        int moveNum = setMoveNum();

    }

    private static List<String> setCarNames () {
        System.out.println(SET_CAR_NAMES);

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        List<String> carNames = List.of(userInput.split(", "));

        for (String carName: carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("[Error] 자동차의 이름은 5자 이내여야 합니다.");
            }
        }

        return carNames;

    }

    private static int setMoveNum () {
        System.out.println(QUESTION_MOVE_NUM);

        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }
}
