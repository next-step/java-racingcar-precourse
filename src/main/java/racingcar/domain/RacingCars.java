package racingcar.domain;

import racingcar.util.Assert;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import static racingcar.util.ListUtils.filter;
import static racingcar.util.ListUtils.map;

public class RacingCars {

    private final List<RacingCar> racingCarList;

    public RacingCars(final List<RacingCar> racingCarList) {
        Assert.notEmpty(racingCarList, String.format("입력 값이 비어있습니다. input: %s", racingCarList));
        this.racingCarList = Collections.unmodifiableList(racingCarList);
    }

    public static RacingCars of(final List<String> carNameList) {
        Assert.notEmpty(carNameList, String.format("입력 값이 비어있습니다. input: %s", carNameList));
        Assert.notDuplicated(carNameList, String.format("중복된 이름이 존재합니다. input: %s", carNameList));
        return new RacingCars(map(carNameList, RacingCar::new));
    }

    public List<RacingCar> getWinners() {
        final RacingCar winner = Collections.max(racingCarList);
        final List<RacingCar> winners = filter(racingCarList, racingCar -> racingCar.isAtSamePosition(winner));
        return Collections.unmodifiableList(winners);
    }

    public void race(final Supplier<MoveCondition> moveConditionSupplier) {
        for (RacingCar racingCar : racingCarList) {
            racingCar.move(moveConditionSupplier.get());
        }
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }
}
