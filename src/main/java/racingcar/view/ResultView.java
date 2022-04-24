package racingcar.view;


import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.utils.MessageUtil;

public class ResultView {

    public void printPosition(Cars cars) {
        List<Car> racingCars = cars.cars();

        for (Car racingCar : racingCars) {
            printPath(racingCar.getName(), racingCar.curPosition());
        }

        printNextLine();
    }

    public void printRacingEndMessage() {
        System.out.println(MessageUtil.CAR_RACING_END_MESSAGE);
    }

    public void printNextLine() {
        System.out.println();
    }

    public void printPath(String name, int cuPosition) {
        StringBuilder path = new StringBuilder();

        for (int i = 0; i < cuPosition; i++) {
            path.append("-");
        }

        System.out.println(name + " : " + path);
    }

    public void printWinners(String winners) {
        if (!"".equals(winners)) {
            System.out.println(String.format(MessageUtil.WINNERS_MESSAGE, winners));
        }
    }

}
