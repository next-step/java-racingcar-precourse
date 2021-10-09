package racinggame.view;

import racinggame.Car;
import racinggame.Cars;
import racinggame.Winners;

public class ResultView {

    private StringBuffer carDistance = new StringBuffer();

    public void printCarsDistance(Cars cars, int tryCount) {

        for (Car car : cars.getCars()) {
            carDistance.append(car.getCarName()).append(":");
            printCarDistance(car, tryCount);
            carDistance.append("\n");
        }
        carDistance.append("\n");
    }

    private void printCarDistance(Car car, int tryCount) {

        for (int i = 0; i < tryCount; i++) {
            matchCarDistance(car, i + 1);
        }

    }

    private void matchCarDistance(Car car, int index) {
        if (car.matchPostion(index)) {
            carDistance.append(new String(new char[index]).replace("\0", "-"));
        }
    }

    public void endRacing() {
        System.out.println(carDistance);
    }

    public void printWinners(Cars cars) {
        Winners winners = Winners.of(cars.getCars());
        System.out.println("최종 우승자는 "+winners.winners()+" 입니다.");
    }
}
