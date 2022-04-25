package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public void run() {
        RacingCarView view = new RacingCarView();
        String[] names = view.getName();
        List<Car> cars = new ArrayList<>();
        int move = view.getMove();

        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }

        CarLists carLists = new CarLists(cars);

        for (int i = 0; i < move; i++) {
            carLists.moveCars(view);
        }
        view.printWinner(cars);
    }
}
