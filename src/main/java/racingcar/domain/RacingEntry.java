package racingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Constants;

public class RacingEntry {
    private final Map<RacingCarName, RacingCarScore> racingEntry;
    private static final int FOUR = 4;
    private static final int NINE = 9;

    Comparator<Entry<RacingCarName, RacingCarScore>> comparator =
            new Comparator<Entry<RacingCarName, RacingCarScore>>() {
                @Override
                public int compare(Entry<RacingCarName, RacingCarScore> e1,
                        Entry<RacingCarName, RacingCarScore> e2) {
                    return e1.getValue().toInt().compareTo(e2.getValue().toInt());
                }
            };

    public RacingEntry(Map<RacingCarName, RacingCarScore> racingEntry) {
        this.racingEntry = racingEntry;
    }

    public RacingResult process(RacingResult result) {
        Set<RacingCarName> keys = racingEntry.keySet();

        for (RacingCarName name : keys) {
            countScore(name);
            result.addMessage(getResultMessage(name, racingEntry.get(name)));
            result.addNewLine();
        }

        result.addNewLine();

        return result;
    }

    public RacingResult getWinner(RacingResult result) {
        RacingCarScore maxScore = Collections.max(racingEntry.entrySet(), comparator).getValue();
        Set<RacingCarName> keys = racingEntry.keySet();
        String winners = "";

        result.addMessage(Constants.MSG_WINNER + Constants.WHITESPACE + Constants.COLON + Constants.WHITESPACE);

        for (RacingCarName name : keys) {
            winners += getWinnerMessage(name, maxScore);
        }

        result.addMessage(winners.substring(Constants.ZERO, winners.length() - Constants.TWO));

        return result;
    }

    private void countScore(RacingCarName name) {
        if (Randoms.pickNumberInRange(Constants.ZERO, NINE) >= FOUR) {
            racingEntry.get(name).addScore();
        }
    }

    private String getResultMessage(RacingCarName name, RacingCarScore score) {
        String str = "";
        str += name.toString() + Constants.WHITESPACE + Constants.COLON + Constants.WHITESPACE; // "pobi : "

        for (int i = Constants.ZERO; i < score.toInt(); i++) {
            str += Constants.HYPHEN;
        }

        return str;
    }

    private String getWinnerMessage(RacingCarName name, RacingCarScore maxScore) {
        String str = "";

        if (racingEntry.get(name).toInt() == maxScore.toInt()) {
            str = name.toString() + Constants.COMMA + Constants.WHITESPACE;
        }

        return str;
    }
}
