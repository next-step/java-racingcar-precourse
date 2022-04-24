package racingcar.domain;

import racingcar.Constant;
import racingcar.domain.car.ParticipatingCars;
import racingcar.domain.count.Count;
import racingcar.domain.race.RacePreparation;
import racingcar.domain.race.RaceProcess;
import racingcar.domain.race.RaceResult;

import java.util.List;
import java.util.Scanner;

public class RaceManager {
    private ParticipatingCars participatingCars;
    private RacePreparation racePreparation;
    private Count count;
    private RaceProcess raceProcess;
    private RaceResult raceResult;
    private int leadPosition = 0;

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

    public void start() {
        System.out.println(Constant.RACE_PROCESS);

        for (int i = 0; i < count.getRound(); i++) {
            this.leadPosition = raceProcess.startrace(participatingCars, leadPosition);
            raceProcess.showCurrentSituation(participatingCars);
        }
    }

    public void showWinner() {
        List<String> winners = raceResult.findWinner(participatingCars, leadPosition);
        raceResult.printWinner(winners);
    }
}
