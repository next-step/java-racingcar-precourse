package racinggame.domain;

import java.util.ArrayList;

public class AllRaceStates {
    private ArrayList<RaceStates> allRaceStates;

    public AllRaceStates() {
        this.allRaceStates = new ArrayList<>();
    }

    public ArrayList<RaceStates> getAllRaceStates() {
        return allRaceStates;
    }

    public void add(RaceStates raceStates) {
        allRaceStates.add(raceStates);
    }
}
