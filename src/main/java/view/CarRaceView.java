package view;

import java.util.List;
import model.Car;

public class CarRaceView {
    public void printWelcomeMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCountMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        System.out.print("최종 우승자: ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
