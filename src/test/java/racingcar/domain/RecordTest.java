package racingcar.domain;

import javafx.util.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;

class RecordTest {
    @Test
    @DisplayName("레코드 기록이 있는 경우")
    void createCarTest() {
        List<Pair<String, Integer>> recordsByRound = new ArrayList<>();
        recordsByRound.add(new Pair<>("abc", 2));
        recordsByRound.add(new Pair<>("test", 0));
        recordsByRound.add(new Pair<>("java", 3));
        Record record = new Record(recordsByRound);
        assertThat(record.getRecordsByRound().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("레코드 기록이 없는 경우")
    void createRecordWithEmptyRecordTest() {
        ThrowingCallable emptyRecord = () -> new Record(Collections.emptyList());
        assertThatThrownBy(emptyRecord).isInstanceOf(IllegalArgumentException.class);
    }

}
