package racinggame;

import racinggame.car.domain.Cars;
import racinggame.car.utils.CarsUtil;
import racinggame.race.RaceTrack;

public class RacingGame {
    public void start() {
        Cars carList = new Cars(CarsUtil.createCars(DataInput.inputCarName()));
        int roundNum = DataInput.inputDoingRound();

        RaceTrack track = new RaceTrack(carList, roundNum);
        track.play();
        track.result();
    }
}
