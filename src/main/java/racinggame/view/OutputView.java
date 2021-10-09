package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.Cars;

import java.util.List;

public class OutputView {
    public void printCarsPosition(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.printf("%s : %s%n", car.getName(), positionToGauge(car.getPosition()));
        }
        System.out.println();
    }

    private String positionToGauge(int position) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }

    public void printWinners(List<Car> winners) {
        System.out.printf("최종 우승자는 %s 입니다.", joiningWinnerName(winners));
    }

    private String joiningWinnerName(List<Car> winners) {
        String[] winnerNameArray = new String[winners.size()];
        for (int i = 0; i < winners.size(); i++) {
            winnerNameArray[i] = winners.get(i).getName();
        }
        return String.join(",", winnerNameArray);
    }
}
