package racingcar;

import racingcar.racing.RacingCar;

public class Application {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();
        try {
            racingCar.startRacing();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            racingCar.startRacing();
        }
    }

}
