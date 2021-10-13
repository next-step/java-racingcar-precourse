package racinggame.view;

import racinggame.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    // 자동차들 위치 출력
    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            String carStatus = String.format("%s : %s", car.getName(), car.getPosition().getPositionToBar());
            System.out.println(carStatus);
        }
        System.out.println();
    }

    // 승자 출력
    public void printWinners(List<Car> winners) {
        List<String> winnersNames = new ArrayList<>();
        for (Car winner : winners) {
            winnersNames.add(winner.getName());
        }
        String result = String.join(",", winnersNames);
        System.out.println(String.format("최종 우승자는 %s 입니다.", result));
    }
}
