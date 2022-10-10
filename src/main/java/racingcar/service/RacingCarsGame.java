package racingcar.service;

import racingcar.domain.MoveCount;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.UserInterFace;

import java.util.ArrayList;
import java.util.List;

public class RacingCarsGame {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final String WINNER_PRINT_MSG = "최종 우승자 : ";

    private final Cars cars;
    private final MoveCount moveCount;

    public RacingCarsGame(){
        cars = mapCars();
        moveCount = mapMoveCount();
    }

    private Cars mapCars(){
        try {
            List<Car> cars = new ArrayList<>();
            for (String name : UserInterFace.getCarNames().split(CAR_NAME_DELIMITER)) {
                cars.add(new Car(name));
            }
            return new Cars(cars);
        } catch (IllegalArgumentException e){
            UserInterFace.printMsg(e.getMessage());
            return mapCars();
        }
    }

    private MoveCount mapMoveCount(){
        try {
            return new MoveCount(UserInterFace.getMoveCount());
        } catch (IllegalArgumentException e){
            UserInterFace.printMsg(e.getMessage());
            return mapMoveCount();
        }
    }

    public void start(){
        for (int i = 0; i < moveCount.getMoveCount(); i++) {
            cars.moveCars();
        }
        printWinners(cars.extractWinners());
    }

    private void printWinners(Cars cars){
        UserInterFace.printMsg(WINNER_PRINT_MSG + cars.extractCarNames());
    }

}
