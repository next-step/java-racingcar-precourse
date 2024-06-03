import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputManager {
    private final NameValidator nameValidator = new NameValidator();

    public List<Car> getCars(Scanner scanner) {
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String input = scanner.nextLine();
                List<String> carNames = nameValidator.validateAndGetNames(input);
                return createCars(carNames);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public int getAttempts(Scanner scanner) {
        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                String input = scanner.nextLine();
                return getValidateAttempts(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private int getValidateAttempts(String input) {
        try {
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException("이동 횟수는 1 이상의 정수여야 합니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 1 이상의 정수여야 합니다.");
        }
    }
}
