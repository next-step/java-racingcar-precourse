package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

import static racinggame.constants.RaceGameConstants.JOIN_REGEX;

public class RaceRound {

    private final List<RaceCar> raceCars;

    public RaceRound(List<RaceCar> raceCars) {
        this.raceCars = deepCopy(raceCars);
    }

    public List<RaceCar> getRaceCars() {
        return raceCars;
    }

    private List<RaceCar> deepCopy(List<RaceCar> origin) {
        ArrayList<RaceCar> copy = new ArrayList<>();
        origin.forEach(o -> copy.add(new RaceCar(o.getName(), o.getMoveCount())));
        return copy;
    }

    public String getRaceRoundWinners() {
        int max = getMaxMoveCount();
        List<String> winnerNames = new ArrayList<>();
        raceCars.forEach(raceCar -> roundWinner(winnerNames, raceCar, max));
        return String.join(JOIN_REGEX, winnerNames);
    }

    private void roundWinner(List<String> winnerNames, RaceCar raceCar, int max) {
        if (raceCar.getMoveCount() == max) {
            winnerNames.add(raceCar.getName());
        }
    }

    private int getMaxMoveCount() {
        int max = 0;
        for (RaceCar raceCar : raceCars) {
            max = Math.max(raceCar.getMoveCount(), max);
        }
        return max;
    }

}