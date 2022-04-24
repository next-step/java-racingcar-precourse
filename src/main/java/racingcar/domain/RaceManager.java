package racingcar.domain;

import racingcar.Constant;
import racingcar.domain.car.ParticipatingCars;
import racingcar.domain.count.Count;
import racingcar.domain.race.RacePreparation;

import java.util.List;
import java.util.Scanner;

public class RaceManager {
    private ParticipatingCars participatingCars;
    private RacePreparation racePreparation;
    private Count count;

    public void generateCars(Scanner scanner) {
        while (true) {
            System.out.println(Constant.PARTICIPATING_CAR_NAME_INPUT_MESSAGE);

            try {
                String[] allCarName = racePreparation.generateRaceCars(scanner);
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
                String number = racePreparation.getRaceCount(scanner);
                this.count = new Count(number);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

//    public void start() {
//        System.out.println(Constant.RACE_PROCESS);
//
//        for (int i = 0; i < round.getRound(); i++) {
//            this.leadPosition = raceProcess.driveCar(cars, leadPosition);
//            raceProcess.showCurrentSituation(cars);
//        }
//    }
//
//    public void showWinner() {
//        List<String> winners = raceResult.findWinner(cars, leadPosition);
//        raceResult.printWinner(winners);
//    }
}
