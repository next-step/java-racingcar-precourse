package racingcar.model;

import racingcar.view.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private int numberOfRaces;
    private Racer racers;

    public Game(int  numberOfRaces, Racer racers) {
        this.numberOfRaces = numberOfRaces;
        this.racers = racers;
    }

    public int  getNumberOfRaces() {
        return numberOfRaces;
    }

}
