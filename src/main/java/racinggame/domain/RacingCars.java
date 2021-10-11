package racinggame.domain;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(String racingCarName) {
        List<CarName> carNames = parseCarNames(racingCarName);
        this.racingCars = createCars(carNames);
    }

    private List<CarName> parseCarNames(String racingCarsName) {
        List<CarName> carNames = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(racingCarsName, ",");

        while (st.hasMoreTokens()) {
            carNames.add(new CarName(st.nextToken()));
        }

        return carNames;
    }

    private static List<RacingCar> createCars(List<CarName> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (CarName carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
        return racingCars;
    }

    public RaceRecords playRound() {
        List<RaceRecord> raceRecords = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            int moveNumber = Randoms.pickNumberInRange(0, 9);
            racingCar.move(moveNumber);
            raceRecords.add(recordRoundRace(racingCar));
        }
        return new RaceRecords(raceRecords);
    }

    private RaceRecord recordRoundRace(RacingCar racingCar) {
        return new RaceRecord(racingCar);
    }

    public RaceResults results() {
        return new RaceResults(racingCars);
    }
}
