import java.util.Scanner;

public class GameInputView {

    private final Scanner scanner;

    public GameInputView() {
        scanner = new Scanner(System.in);
    }

    private void validatorInputCarNameList(String[] carNames) {
        for (String car : carNames) {
            if ((car.isEmpty()) || (car.length() > 5)) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름을 쉼표로 구분해주시고, 각 이름의 길이는 5자 이하로 작성해주세요.");
            }
        }
    }

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = scanner.nextLine().split(",");

        while (true) {
            try {
                validatorInputCarNameList(carNames);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                carNames = scanner.nextLine().split(",");
            }
        }

        return carNames;
    }

    private void validatorInputPlayCountString(String playCountString) {
        if (!playCountString.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 0을 제외한 정수를 입력해주세요.");
        }

        if (Integer.parseInt(playCountString) == 0) {
            throw new IllegalArgumentException("[ERROR] 0을 제외한 정수를 입력해주세요.");
        }
    }

    public int inputPlayCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String playCountString = scanner.nextLine();

        while (true) {
            try {
                validatorInputPlayCountString(playCountString);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                playCountString = scanner.nextLine();
            }
        }

        System.out.println();
        return Integer.parseInt(playCountString);
    }

    public void close() {
        scanner.close();
    }
}
