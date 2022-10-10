package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.utils.Constants;

public class CarGameViewer {
    private final static String BAR = "-";

    public String getCarNames() {
        System.out.println(Constants.MESSAGE_CAR_NAME_INPUT+Constants.MESSAGE_CAR_NAME_CONDITION);
        return readLine();
    }

    public String getRepeatCount() {
        System.out.println(Constants.MESSAGE_GAME_REPEAT_COUNT);
        return readLine();
    }

    public void printCarsStatus(Cars cars) {
        for(Car car : cars.getCars()) {
            System.out.printf(Constants.MESSAGE_CAR_INFO_PRINT, car.getCarName(), changePositionToBar(car.getCarPosition()));
        }
        System.out.println();
    }

    public void printGameResult(Cars winningCars) {
        System.out.print(Constants.MESSAGE_FINAL_WINNER);
        System.out.println(winningCars.toString());
    }

    private String changePositionToBar(Integer position) {
        StringBuilder stringBuilder = new StringBuilder();
        while(position > 0) {
            stringBuilder.append(BAR);
            position = position - 1;
        }

        return stringBuilder.toString();
    }
}
