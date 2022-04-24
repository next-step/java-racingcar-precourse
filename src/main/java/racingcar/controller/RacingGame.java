package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Cars;
import racingcar.model.Champion;
import racingcar.model.Names;
import racingcar.model.Repeat;
import racingcar.view.Circuit;
import racingcar.view.Receipt;

public class RacingGame {
    private Cars cars;
    private Repeat repeat;

    public void start() {
        set();
        play();
        result();
    }

    private void result() {
        Champion champion = Champion.pick(cars);
        Circuit.printChampion(champion.announce());
    }

    private void set() {
        cars = setCarNames();
        repeat = setRepeatNumbers();
    }

    private Repeat setRepeatNumbers() {
        try {
            Receipt.printInputRepeatNumber();
            return Repeat.valueOf(Console.readLine());
        } catch (IllegalArgumentException e) {
            Receipt.printErrorMessage(e);
            return setRepeatNumbers();
        }
    }

    private Cars setCarNames() {
        try {
            Receipt.printInputCarNames();
            Names names = Names.valueOf(Console.readLine());
            return Cars.create(names);
        } catch (IllegalArgumentException e) {
            Receipt.printErrorMessage(e);
            return setCarNames();
        }
    }

    private void play() {
        Circuit.printRaceStart();
        repeatPlay(repeat.getNumber());
    }

    private void repeatPlay(int repeatNumber) {
        if (repeatNumber == 0) {
            return;
        }
        cars.move();
        Circuit.printCarsPosition(cars);
        repeatPlay(repeatNumber - 1);
    }
}
