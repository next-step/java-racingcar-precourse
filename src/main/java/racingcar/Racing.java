package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Racing {
    public static final String PRINT_RESULT_INSTRUCTOR = "실행 결과\n";
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 10;
    private final Cars cars;
    private final LapCount lapCount;

    private Racing(CarNames carNames, LapCount lapCount) {
        this.lapCount = lapCount;
        this.cars = Cars.createCars(carNames);
    }

    public static Racing setRacingCondition(CarNames carNames, LapCount lapCount) {
        return new Racing(carNames, lapCount);
    }

    private void lap() {
        for (Car car : cars.getCars()) {
            car.goOrNot(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
            RacingResult.printLabResult(car);
        }
        System.out.print("\n");
    }

    public void start() {
        System.out.print(PRINT_RESULT_INSTRUCTOR);
        for (int i = 0; i < this.lapCount.getLapCount(); i++) {
            lap();
        }
    }

    public Cars getCars() {
        return this.cars;
    }
}
