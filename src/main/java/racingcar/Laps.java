package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Laps {

    private final List<Lap> laps;

    public Laps() {
        laps = new ArrayList<>();
    }

    public void addLap(Lap lap) {
        laps.add(lap);
    }

    public Lap getFinalLap() {
        return laps.get(laps.size() - 1);
    }


}
