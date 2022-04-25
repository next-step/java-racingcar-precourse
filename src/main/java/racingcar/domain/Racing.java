package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.Messages;

import java.util.List;

public class Racing {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public void play() {
        RacingCars racingCars = carSetUp();
        RepeatCount repeatCount = repeatSetUp();

        List<RacingCar> cars = racingCars.getRacingCars();
        for (int i = 0; i < repeatCount.getCount(); i++) {
            racingStart(cars);
            System.out.println();
        }
        System.out.println(new RacingResult(cars).winners());
    }

    private void racingStart(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            int pickedNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            car.move(pickedNumber);
        }
    }

    private RacingCars carSetUp() {
        System.out.println(Messages.START_MESSAGE);
        RacingCars racingCars = new RacingCars();

        try {
            addCar(racingCars, Console.readLine().split(","));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return carSetUp();
        }
        return racingCars;
    }

    private void addCar(RacingCars racingCars, String[] carNames) {
        for (String carName : carNames) {
            RacingCar racingCar = new RacingCar(new RacingCarName(carName));
            racingCars.addRacingCar(racingCar);
        }
    }

    private RepeatCount repeatSetUp() {
        System.out.println(Messages.REPEAT_COUNT_SETTING);
        try {
            return new RepeatCount(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeatSetUp();
        }
    }
}
