package racinggame;

import racinggame.domain.Race;
import racinggame.domain.RaceFactory;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        RaceFactory raceFactory = new RaceFactory();
        Race race = raceFactory.buildRace();
        race.drive();
    }
}
