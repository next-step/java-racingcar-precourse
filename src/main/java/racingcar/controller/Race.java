package racingcar.controller;

import static racingcar.configuration.PrintMessage.INPUT_CAR_NAME_MSG;
import static racingcar.configuration.PrintMessage.INPUT_RACE_ROUND_MSG;
import static racingcar.configuration.PrintMessage.OUTPUT_RESULT_MSG;
import static racingcar.configuration.PrintMessage.OUTPUT_WINNER_MSG;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Round;

public class Race {
    private static final int UNDER_BOUND_NUMBER = 0;
    private static final int UPPER_BOUND_NUMBER = 9;
    private Cars cars;
    private Round round;

    public void setCarNames() {
        try {
            this.cars = new Cars(Arrays.asList(getCarNamesInput().split(",")));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setCarNames();
        }
    }

    private String getCarNamesInput() {
        System.out.println(INPUT_CAR_NAME_MSG);
        return Console.readLine();
    }

    public List<Car> findCars() {
        return cars.findCars();
    }

    public int getRound() {
        return this.round.getRound();
    }

    public void setRaceRound() {
        try {
            this.round = new Round(getRaceRoundInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setRaceRound();
        }

    }

    private String getRaceRoundInput() {
        System.out.println(INPUT_RACE_ROUND_MSG);
        return Console.readLine();
    }

    public void start() {
        setCarNames();
        setRaceRound();
        racing();
    }

    public void racing() {
        for (int i = 0; i < getRound(); i++) {
            setPositions();
            System.out.println(OUTPUT_RESULT_MSG);
            System.out.println(getRoundResult());
            System.out.println("\n");
        }
        System.out.println(getRaceResult());
    }

    public void setPositions() {
        for (Car car : cars.findCars()) {
            car.setPosition(getRandomNumber());
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(UNDER_BOUND_NUMBER, UPPER_BOUND_NUMBER);
    }

    public String getRoundResult() {
        return cars.getResults();
    }

    public String getRaceResult() {
        List<String> result = new ArrayList<>();
        for (Car car : findCars()) {
            setWinnerNames(result, car);
        }
        StringJoiner sj = new StringJoiner(", ");
        for (String str : result) {
            sj.add(str);
        }
        return OUTPUT_WINNER_MSG + sj;
    }

    private void setWinnerNames(List<String> result, Car car) {
        if (isWinner(car)) {
            result.add(car.getName());
        }
    }

    private boolean isWinner(Car car) {
        return car.getScore() == getMaxScoreInRace();
    }

    public int getMaxScoreInRace() {
        int maxScore = Integer.MIN_VALUE;
        for (Car car : findCars()) {
            maxScore = getMaxScore(maxScore, car);
        }
        return maxScore;
    }

    private int getMaxScore(int maxScore, Car car) {
        return Math.max(maxScore, car.getScore());
    }
}
