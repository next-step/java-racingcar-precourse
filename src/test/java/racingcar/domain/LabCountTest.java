package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LabCountTest {

    @DisplayName("LabCount의 생성자로 초기화 및 게터를 사용한 값 정수값 추출")
    @Test
    void labCount() {
        // given & when
        LabCount labCount = new LabCount("5");

        // expected
        assertThat(labCount.getCount()).isEqualTo(5);
    }
}