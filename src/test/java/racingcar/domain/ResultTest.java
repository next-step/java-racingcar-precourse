package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    @DisplayName("초기 생성시 비어있는 리스트를 가진 객체가 생성된다.")
    void createResultTest() {
        Result initialResult = Result.createInitialResult();
        assertThat(initialResult.getRecordsList()).isEmpty();
    }

    @Test
    @DisplayName("Records 객체를 더할 수 있다.")
    void addRecordTest() {
        Result initialResult = Result.createInitialResult();
        Records records = Records.of(new ArrayList<>());
        initialResult.add(records);
        assertThat(initialResult.getRecordsList()).hasSize(1);
        assertThat(initialResult.getRecordsList()).containsExactly(records);
    }
}