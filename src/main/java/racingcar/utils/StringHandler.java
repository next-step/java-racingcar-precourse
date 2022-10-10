package racingcar.utils;
import racingcar.entities.Car;

import java.util.ArrayList;
public class StringHandler {
    public static final String SPLIT_EXPRESSION = ",";

    public String insertCommaBetweenWinnersName(ArrayList<Car> winnerCars) {
        StringBuilder winnerCarsNameString = new StringBuilder();
        winnerCarsNameString.append(winnerCars.remove(0).getName());
        for(Car car :winnerCars)
            winnerCarsNameString.append(SPLIT_EXPRESSION).append(" ").append(car.getName());

        return winnerCarsNameString.toString();

    }
}
