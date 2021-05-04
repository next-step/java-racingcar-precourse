package controller;

import domain.Car;
import validation.RaceValidation;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private static final int INIT_POSITION = 0;

    public static int parseIntTryCount(String tryCount) {
        RaceValidation.raceCountValided(tryCount);
        return Integer.parseInt(tryCount);
    }

    private static int findLeadPosition(List<Car> cars) {
        int leadPosition = INIT_POSITION;

        for (Car car : cars) {
            leadPosition = getLeadPosition(leadPosition, car);
        }
        return leadPosition;
    }

    private static int getLeadPosition(int leadPosition, Car car) {
        if (leadPosition < car.getPosition()) {
            return car.getPosition();
        }
        return leadPosition;
    }

    public static void findIsWinners(List<Car> cars) {
        int leadPosition = findLeadPosition(cars);

        for (Car car : cars) {
            setIsWinners(leadPosition, car);
        }
    }

    private static void setIsWinners(int leadPosition, Car car) {
        if (car.getPosition() == leadPosition) {
            car.setIsWinner();
        }
    }

    private static void findWinnerNames(List<String> winnerNames, Car car) {
        if (car.getIsWinner()) {
            winnerNames.add(car.getName());
        }
    }

    public static String getResultLane(Car car) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(car.getName());
        stringBuilder.append(" : ");
        for(int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public static String getWinnersLane(List<String> winnerNames) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(winnerNames.get(0));
        for (int i = 1; i < winnerNames.size(); i++) {
            stringBuilder.append(", ");
            stringBuilder.append(winnerNames.get(i));
        }
        return stringBuilder.toString();
    }

    public static List<String> getWinnerNames(List<Car> cars) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            findWinnerNames(winnerNames, car);
        }
        return winnerNames;
    }
}
