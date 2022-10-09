package racingcar.view;

import racingcar.model.Car;
import racingcar.model.WinCars;

import static racingcar.constant.GuideMessage.EXECUTION_RESULT;
import static racingcar.constant.GuideMessage.FINAL_WINNER;

public class RacingProgress {

    public void printExecutionResult() {
        System.out.println();
        System.out.println(EXECUTION_RESULT);
    }

    public void printRacingResultEachCar(Car car) {
        String racingResultMessage =
                new StringBuilder(car.getName())
                        .append(" : ")
                        .append(car.getRacingRoad())
                        .toString();
        System.out.println(racingResultMessage);
    }

    public void printFinalRacingResult(WinCars winCars) {
        System.out.print(FINAL_WINNER);
        StringBuilder resultMessage = new StringBuilder();
        boolean first = true;
        for (Car car : winCars.getWinCars()) {
            resultMessage.append(appendResultMessage(first, car));
            first = false;
        }
        System.out.print(resultMessage.toString());
    }

    private String appendResultMessage(boolean first, Car car) {
        if (first) {
            return car.getName();
        }
        return new StringBuilder(", ").append(car.getName()).toString();
    }

    public static void printBlankOneLine() {
        System.out.println();
    }

}
