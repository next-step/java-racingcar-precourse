import java.util.Scanner;

public class GameInputView {

    private void validatorInputCarNameList(String[] carNames) {
        for (String car : carNames) {
            if ((car.isEmpty()) || (car.length() > 5)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public String[] inputCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = scanner.nextLine().split(",");

        while (true) {
            try {
                validatorInputCarNameList(carNames);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 자동차 이름을 쉼표로 구분해주시고, 각 이름의 길이는 5자 이하로 작성해주세요.");
                carNames = scanner.nextLine().split(",");
            }
        }

        scanner.close();
        return carNames;
    }

    public int inputPlayCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        String playCountString = scanner.nextLine();

        return Integer.parseInt(playCountString);
    }
}
