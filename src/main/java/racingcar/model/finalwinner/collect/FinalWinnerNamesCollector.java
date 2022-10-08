package racingcar.model.finalwinner.collect;

import racingcar.model.finalwinner.FinalWinnerName;

import java.util.ArrayList;
import java.util.Map;

public class FinalWinnerNamesCollector {
    private final Map<String, Integer> advanceMap;
    private final int maxAdvance;

    public FinalWinnerNamesCollector(Map<String, Integer> advanceMap, int maxAdvance) {
        this.advanceMap = advanceMap;
        this.maxAdvance = maxAdvance;
    }

    public ArrayList<FinalWinnerName> collect() {
        ArrayList<FinalWinnerName> finalWinnerNames = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : advanceMap.entrySet()) {
            OnCurrentAdvanceIsMaxAdvanceAdder onCurrentAdvanceIsMaxAdvanceAdder =
                    new OnCurrentAdvanceIsMaxAdvanceAdder(finalWinnerNames, entry, maxAdvance);
            onCurrentAdvanceIsMaxAdvanceAdder.add();
        }
        return finalWinnerNames;
    }
}
