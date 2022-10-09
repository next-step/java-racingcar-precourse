package racingcar.domain;

import racingcar.dto.RecordDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing {
    private final Entry entry;
    private final Lap lap;

    private Racing(Entry entry, Lap lap) {
        this.entry = entry;
        this.lap = lap;
    }

    public static Racing of(Entry entry, Lap lap) {
        return new Racing(entry, lap);
    }

    public RecordDto race(Movement movement) {
        List<List<String>> lapPositions = new ArrayList<>();
        for (int i = 0; i < lap.get(); i++) {
            lapPositions.add(entry.race(movement));
        }
        return RecordDto.of(Collections.unmodifiableList(lapPositions), entry.winners());
    }
}
