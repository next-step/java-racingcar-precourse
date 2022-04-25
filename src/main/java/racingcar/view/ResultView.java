package racingcar.view;


import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.winner.Winners;

public class ResultView {

    private final StringBuffer recordCarDistance = new StringBuffer();

    public void printCarsDistance(Cars cars, int tryCount) {

        for (Car car : cars.getCars()) {
            recordCarDistance.append(car.getCarName()).append(" : ");
            printCarDistance(car, tryCount);
            recordCarDistance.append("\n");
        }
        recordCarDistance.append("\n");
    }

    private void printCarDistance(Car car, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            matchCarDistance(car, i + 1);
        }
    }

    private void matchCarDistance(Car car, int index) {
        if (car.matchPosition(index)) {
            recordCarDistance.append(new String(new char[index]).replace("\0", "-"));
        }
    }

    public void endRacing() {
        System.out.println(recordCarDistance);
    }

    public void printWinners(Cars cars) {
        String resultWinner = "";

        Winners winners = Winners.of(cars.getCars());

        resultWinner = putInWinner(resultWinner, winners);
        System.out.println("최종 우승자: " + removeLastString(resultWinner));
    }

    private String removeLastString(String resultWinner) {
        return resultWinner.substring(0, resultWinner.length() - 1);
    }

    private String putInWinner(String resultWinner, Winners winners) {
        for (String winner : winners.getWinners()) {
            resultWinner += winner + ",";
        }
        return resultWinner;
    }
}
