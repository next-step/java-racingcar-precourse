package racinggame.service;

import nextstep.utils.Console;
import racinggame.domain.*;
import racinggame.message.MessageType;

import java.util.ArrayList;
import java.util.List;

public class RaceService {

    public String[] splitNameWithComma(InputCarsName inputCarsName) {
        return inputCarsName.getName().split(",");
    }

    public Cars createCars(String[] carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNameList) {
            carList.add(Car.of(CarName.of(name)));
        }
        return Cars.of(carList);
    }

    public String getWinner(Cars cars) {
        final int max = getMaxPosition(cars.getCars());
        return retrieveWinnerWithMaxValue(cars.getCars(), max);
    }


    public void inputCarsName(Player player) {
        System.out.println(MessageType.INPUT_CAR_NAME.getMessage());
        player.inputCarsName(InputCarsName.of(Console.readLine()));
    }

    public void inputRaceNumber(Player player) {
        System.out.println(MessageType.INPUT_RACE_NUMBER.getMessage());
        player.inputRaceNumber(RaceNumber.of(Console.readLine()));
    }

    public String retrieveWinnerWithMaxValue(List<Car> carsList, int max) {
        List<String> winners = new ArrayList<>();
        for (Car car : carsList) {
            if (car.getCarPosition().getValue() == max) {
                winners.add(car.getCarName().getName());
            }
        }
        return winners.toString();
    }

    private int getMaxPosition(List<Car> carsList) {
        int max = Integer.MIN_VALUE;
        for (Car car : carsList) {
            if (car.getCarPosition().getValue() > max) {
                max = car.getCarPosition().getValue();
            }
        }
        return max;
    }


    public void printWinner(String winner) {
        final String winners = winner.substring(1, winner.length() - 1);
        System.out.println(MessageType.RACING_WINNER_START.getMessage() + winners + MessageType.RACING_WINNER_END.getMessage());

    }
}
