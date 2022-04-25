package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordLineTest extends NsTest {

    @Test
    @DisplayName("자동차_주행거리_표시_테스트")
    void 자동차_주행거리_표시_테스트() {
        RecordLine recordLine = new RecordLine();
        recordLine.addRecordLine();
        recordLine.writeRecordLine("krad");
        assertThat(output()).contains("krad : -");
    }

    @Override
    protected void runMain() {

    }
}
