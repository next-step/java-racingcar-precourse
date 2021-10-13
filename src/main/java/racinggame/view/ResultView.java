package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.Cars;

public class ResultView {
    public static void printResultSubject() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printCar(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getCarName() + " : ");
            printCarPosition(car);
            System.out.println();
        }
        System.out.println();
    }

    private static void printCarPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printWinner(String winners) {
        System.out.println("최종 우승자는 " + winners + " 입니다.");
    }
}
