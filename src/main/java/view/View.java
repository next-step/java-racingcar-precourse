package view;

import model.Car;

import java.util.List;
import java.util.Scanner;

public class View {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * 사용자로부터 자동차 이름을 입력받는 메서드
     * @return 입력받은 자동차 이름 리스트
     */
    public List<String> getCarNames() {
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String input = scanner.nextLine();
                String[] names = input.split(",");
                for (String name : names) {
                    new Car(name); // 이 과정에서 예외가 발생할 수 있음
                }
                return List.of(names);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    /**
     * 사용자로부터 시도할 회수를 입력받는 메서드
     * @return 입력받은 시도할 회수
     */
    public int getTrialCount() {
        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력하세요.");
            }
        }
    }

    public void displayRaceResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    public void displayWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
