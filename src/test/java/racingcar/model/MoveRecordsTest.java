package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveRecordsTest {
    @DisplayName("움직임기록이 정상적으로 추가되는지 테스트")
    @Test
    void addRecord() {
        MoveRecords moveRecords = new MoveRecords();
        moveRecords.addRecord(new MoveRecord(true));
        moveRecords.addRecord(new MoveRecord(false));

        assertThat(moveRecords.getRecords()).hasSize(2);
        assertThat(moveRecords.getRecords().get(0).isMoved()).isEqualTo(true);
        assertThat(moveRecords.getRecords().get(1).isMoved()).isEqualTo(false);
    }
}
