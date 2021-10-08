package racinggame.domain;

import nextstep.utils.StringBuilderUtils;

import java.util.ArrayList;
import java.util.List;

import static racinggame.type.StringConstants.LINE_FEED;

public class RacingRecords {

    private final List<RacingRecord> racingRecords;

    public RacingRecords() {
        racingRecords = new ArrayList<>();
    }

    public void addResult(RacingRecord result) {
        racingRecords.add(result);
    }

    public int size() {
        return racingRecords.size();
    }

    public RacingRecord get(int idx) {
        return racingRecords.get(idx);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            sb.append(racingRecords.get(i).toString()).append(LINE_FEED.getValue());
        }
        return StringBuilderUtils.deleteLastText(sb, LINE_FEED.getValue()).toString();
    }
}
