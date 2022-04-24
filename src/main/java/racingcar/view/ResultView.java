package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    public static void racingResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + convertPositionToHyphen(car.getPosition()));
        }
        System.out.println();
    }

    public static void racingWinnerResult(List<Car> racingWinners) {
        String winnerNames = "";
        for (Car car : racingWinners) {
            winnerNames = winnerNames + car.getName() + ",";
        }
        System.out.println("최종 우승자: " + winnerNames.substring(0, winnerNames.length() - 1));
    }

    public static String convertPositionToHyphen(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
