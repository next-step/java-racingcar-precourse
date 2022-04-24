package racingcar.domain;

import racingcar.Constant;
import racingcar.domain.car.ParticipatingCars;
import racingcar.domain.car.RaceCar;
import racingcar.domain.count.Count;

import java.util.Scanner;

public class RaceManager {
    private ParticipatingCars participatingCars;
    private RaceCar raceCar;
    private Count count;

    public void run(Scanner scanner) {
        while (true) {
            System.out.println(Constant.PARTICIPATING_CAR_NAME_INPUT_MESSAGE);

            try {
                String[] allCarName = raceCar.generateRaceCars(scanner);
                this.participatingCars = new ParticipatingCars(allCarName);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setRaceCount(Scanner scanner) {
        while (true) {
            System.out.println(Constant.RACE_ROUND_INPUT_MESSAGE);

            try {
                String number = raceCar.getRaceCount(scanner);
                this.count = new Count(number);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
