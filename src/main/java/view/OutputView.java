package view;

import java.util.ArrayList;
import model.Car;

public class OutputView {

    public void showExecutionResult() {
        System.out.println("실행 결과");
    }

    public void showCarMove(Car car) {
        int distance = car.getDistance();
        String name = car.getName();

        System.out.println(name + " : " + ("-".repeat(distance)));
    }

    public void showWinner(ArrayList<Car> cars) {
        ArrayList<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.isWinner()) {
                winners.add(car.getName());
            }
        }

        String winnersName = String.join(",", winners);

        System.out.println("최종 우승자 : " + winnersName);
    }
}
