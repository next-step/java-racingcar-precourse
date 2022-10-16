package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.Out;

public class RacingGame {

    public static void play() {
        RacingCars racingCars;
        racingCars = inputRacingCars();
        inputRacingCount(racingCars);
        racingCars.printResult();
    }

    public static RacingCars inputRacingCars(){
        Out.printInputTheRacingCarNames();
        try {
            return new RacingCars(Console.readLine());
        } catch (IllegalArgumentException e){
            Out.printValidNameOneToFile();
            return inputRacingCars();
        }
    }

    private static void inputRacingCount(RacingCars cars) {
        Out.printInputTheRacingCount();
        try {
            cars.race(Integer.valueOf(Console.readLine()));
        } catch (NumberFormatException e) {
            Out.printValidRaceCount();
            inputRacingCount(cars);
        }
    }

}
