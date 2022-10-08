package racingcar.model.finalwinner.collect;

import racingcar.model.finalwinner.FinalWinnerName;

import java.util.ArrayList;
import java.util.Map;

public class OnCurrentAdvanceIsMaxAdvanceAdder {
    private final ArrayList<FinalWinnerName> finalWinnerNames;
    private final Map.Entry<String, Integer> entry;
    private final int maxAdvance;

    public OnCurrentAdvanceIsMaxAdvanceAdder(ArrayList<FinalWinnerName> finalWinnerNames,
                                             Map.Entry<String, Integer> entry,
                                             int maxAdvance) {
        this.finalWinnerNames = finalWinnerNames;
        this.entry = entry;
        this.maxAdvance = maxAdvance;
    }

    public void add() {
        if (entry.getValue() == maxAdvance) {
            finalWinnerNames.add(new FinalWinnerName(entry.getKey()));
        }
    }
}
