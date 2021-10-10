package racinggame.service;

import racinggame.domain.RaceCar;
import racinggame.domain.RaceGame;
import racinggame.domain.RaceFinishResult;
import racinggame.domain.RaceRound;

import java.util.ArrayList;
import java.util.List;

public class RaceGameService {

    public RaceFinishResult startRace(List<String> inputCars, int inputCount) {
        RaceGame raceGame = new RaceGame(inputCars);
        List<RaceRound> raceRounds = new ArrayList<>();
        for (int i = 0; i < inputCount; i++) {
            List<RaceCar> raceRound = raceGame.run();
            raceRounds.add(new RaceRound(raceRound));
        }
        return new RaceFinishResult(raceRounds);
    }

}
