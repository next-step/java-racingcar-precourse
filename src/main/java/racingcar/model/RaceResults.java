package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RaceResults {
    private static final int FIRST = 0;
    private static final int SAME = 0;
    private static final String LINE_SEPARATOR = "line.separator";
    private List<RaceResult> raceResults;

    public RaceResults(List<RaceResult> raceResults) {
        this.raceResults = raceResults;
    }

    public List<String> getWinners() {
        List<String> names = new ArrayList<>();
        raceResults.sort(Comparator.reverseOrder());
        RaceResult firstResult = raceResults.get(FIRST);
        names.add(firstResult.getCarName());
        findCoWinners(firstResult, names);
        return names;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (RaceResult raceResult: raceResults) {
            String s = raceResult.toString();
            sb.append(s);
            sb.append(System.getProperty(LINE_SEPARATOR));
        }
        return sb.toString();
    }

    private void findCoWinners(RaceResult firstResult, List<String> names) {
        int i = FIRST + 1;
        boolean addition = true;
        while (addition && i < raceResults.size()) {
            RaceResult raceResult = raceResults.get(i);
            addition = addCoWinners(names, firstResult, raceResult);
            i++;
        }
    }

    private boolean addCoWinners(List<String> names, RaceResult firstResult, RaceResult raceResult) {
        if (raceResult.compareTo(firstResult) == SAME) {
            names.add(raceResult.getCarName());
            return true;
        }
        return false;
    }
}
