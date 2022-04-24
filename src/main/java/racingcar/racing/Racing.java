package racingcar.racing;

import static java.lang.Math.max;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.car.Car;

public class Racing {
    final List<RacingLine> racingLines;
    final int maxRacingRound;
    private int currentRacingRound;

    public static Racing fromCars(List<Car> cars, int maxRacingRound) {
        return new Racing(toRacingLines(cars), maxRacingRound);
    }

    Racing(List<RacingLine> racingLines, int maxRacingRound) {
        assertMaxRacingRound(maxRacingRound);
        this.maxRacingRound = maxRacingRound;
        this.racingLines = racingLines;
        this.currentRacingRound = 0;
    }

    public List<RacingLine> getRacingLines() {
        return racingLines;
    }

    public int getMaxRacingRound() {
        return this.maxRacingRound;
    }

    public void play() {
        increaseRacingRound();
        for (RacingLine racingLine : racingLines) {
            racingLine.goStraight();
        }
    }

    private void increaseRacingRound() {
        if (isRacingEnd()) {
            throw new IllegalStateException("이미 종료된 레이싱입니다");
        }
        currentRacingRound++;
    }

    public boolean isRacingEnd() {
        return currentRacingRound >= maxRacingRound;
    }

    static private List<RacingLine> toRacingLines(List<Car> cars) {
        assertRacingCars(cars);

        List<RacingLine> toRacingLines = new ArrayList<>(cars.size());

        for (Car car : cars) {
            toRacingLines.add(new RacingLine(car));
        }

        return toRacingLines;
    }

    static private void assertRacingCars(List<Car> cars) {
        if (cars == null) {
            throw new IllegalArgumentException("레이싱을 생성하기 위한 자동차 리스트가 null 입니다");
        } else if (cars.isEmpty()) {
            throw new IllegalArgumentException("레이싱을 위해서는 1대 이상의 자동차가 필요합니다");
        }
    }

    private void assertMaxRacingRound(int maxRacingRound) {
        if (maxRacingRound < 1) {
            throw new IllegalArgumentException("레이싱은 1 회 이상 진행해야합니다");
        }
    }

    public Set<Car> getFirstCars() {
        int firstPosition = 0;
        Set<Car> firstCars = new HashSet<>();
        for (RacingLine racingLine : racingLines) {
            firstPosition = max(racingLine.getPosition(), firstPosition);
            aggregateFirstCars(firstPosition, firstCars, racingLine);
        }
        return firstCars;
    }

    private void aggregateFirstCars(int firstPosition, Set<Car> firstCars, RacingLine racingLine) {
        int position = racingLine.getPosition();

        if (position < firstPosition) {
            return;
        } else if (position > firstPosition) {
            firstCars.clear();
        }
        firstCars.add(racingLine.getRacingCar());
    }

}
