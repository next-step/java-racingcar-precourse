package racingcar.util;

import org.junit.jupiter.api.Test;
import racingcar.model.Name;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ValidationTest {
    @Test
    void 문자열_중복_체크() {
        // given
        Validation validation = new Validation();
        String[] str = {"pobi", "dobi", "pobi"};
        // when
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validation.isDuplicated(str));
    }
    @Test
    void 참가자_인원_체크_부족_테스트() {
        // given
        String[] str = {"pobi"};
        Validation validation = new Validation();
        // when
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validation.hasNotEnoughParticipant(str));
    }
}
