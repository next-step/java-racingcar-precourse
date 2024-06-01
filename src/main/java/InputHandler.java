import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> getCarNames() {
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String input = scanner.nextLine();
                List<String> carNames = Arrays.asList(input.split(","));
                InputValidator.validateCarNames(carNames);
                return carNames;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public int getTrialCount() {
        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                int trialCount = Integer.parseInt(scanner.nextLine());
                InputValidator.validateTrialCount(trialCount);
                return trialCount;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
