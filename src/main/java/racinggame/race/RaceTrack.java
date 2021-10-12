package racinggame.race;

import racinggame.Enum.StartGuide;
import racinggame.car.domain.Cars;

public class RaceTrack {
    private final Cars cars;
    private final int roundNum;

    public RaceTrack(Cars car, final int roundNum) {
        this.cars = car;
        this.roundNum = roundNum;
    }

    public void play() {
        System.out.println(StartGuide.GAME_START_MSG.getMsg());
        for(int i = 0; i< roundNum; i++) {
            cars.roundOneRun();
            System.out.println(cars.toString());
        }
    }
}
