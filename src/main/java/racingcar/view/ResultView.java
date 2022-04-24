package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class ResultView {

    private ResultView() {
    }
    public static void printStartResult(){
        System.out.println("실행 결과");
    }
    public static void printCars(Cars cars) {
        System.out.println(cars.getCarsStatus());
    }

    public static void printWinners(Cars cars) {
        final StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자: ");
        List<Car> winners = cars.isWinners();
        sb.append(winners.get(0).getCarName());
        for (int i = 1; i < winners.size(); i++) {
            sb.append(", " + winners.get(i).getCarName());
        }
        System.out.println(sb);
    }
}
