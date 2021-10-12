package nextstep.controller;

import nextstep.domain.Round;
import nextstep.dto.MoveResult;
import nextstep.domain.Race;
import nextstep.view.RaceView;

import java.util.List;
import java.util.NoSuchElementException;

public class RaceController {

    private final RaceView view;

    public RaceController(RaceView view) {
        this.view = view;
    }

    public void start() {
        Race race = createRace();
        Round round = createRound();

        raceRound(race, round);
        view.displayWinner(race.result());
    }

    private Round createRound() {
        String value = view.getRound();
        Round round = null;
        try {
            round = new Round(value);
        } catch (IllegalArgumentException e) {
            round = createRound();
        }
        return round;
    }

    private Race createRace() {
        String names = view.getNames();
        Race race = null;
        try {
            race = new Race(names);
        } catch (NoSuchElementException e) {
            race = createRace();
        }
        return race;
    }

    private void raceRound(Race race, Round round) {
        view.displayResult();
        for (int i = 0; i < round.getRound(); i++) {
            List<MoveResult> results = race.move();
            raceEachRound(results);
            view.nextLine();
        }
    }

    private void raceEachRound(List<MoveResult> results) {
        for (MoveResult result : results) {
            view.displayRace(result);
        }
    }
}
