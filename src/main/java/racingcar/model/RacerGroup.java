package racingcar.model;
import java.util.ArrayList;

public class RacerGroup {
    private final ArrayList<Racer> racerGroup;

    public RacerGroup() {
        racerGroup = new ArrayList<>();
    }

    public void append(Racer racer) {
        racerGroup.add(racer);
    }

    public void reset() {
        racerGroup.clear();
    }

    public void runARace() {
        for (Racer racer : racerGroup) {
            racer.drive();
        }
    }

    public ArrayList<Racer> getRacerGroup() { return racerGroup;}

    public String toStringCarDistanceByRacer() {
        StringBuilder scoreboard = new StringBuilder();
        String newLine = "\n";
        for (Racer racer: racerGroup) {
            scoreboard.append(racer.getCar().toStringCarDistance()).append(newLine);
        }

        return scoreboard.toString();
    }
}
