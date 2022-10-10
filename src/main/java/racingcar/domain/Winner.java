package racingcar.domain;

import racingcar.common.Number;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private final String[] names;

    public Winner(Cars cars) {
        names = toNames(getJointWinner(getFastestCar(cars), cars));
    }

    private Car getFastestCar(Cars cars) {
        Car winner = cars.getCar(Number.ZERO);

        for (int index = 1; index < cars.getRaceCarCount(); index++) {
            winner = getCarFasterThan(cars.getCar(index), winner);
        }

        return winner;
    }

    private Car getCarFasterThan(Car target, Car winner) {
        if (target.isMoveMoreThen(winner)) {
            return target;
        }

        return winner;
    }

    private Cars getJointWinner(Car winner, Cars cars) {
        List<Car> winners = new ArrayList<>();

        for (int index = 0; index < cars.getRaceCarCount(); index++) {
            addJointWinner(winner, cars.getCar(index), winners);
        }

        return new Cars(winners);
    }

    private void addJointWinner(Car winner, Car target, List<Car> winners) {
        if (winner.isSameDistance(target)) {
            winners.add(target);
        }
    }

    private String[] toNames(Cars winners) {
        String[] names = new String[winners.getRaceCarCount()];

        for (int index = 0; index < winners.getRaceCarCount(); index++) {
            names[index] = winners.getCar(index).getName();
        }

        return names;
    }

    public String[] getNames() {
        return names;
    }
}
