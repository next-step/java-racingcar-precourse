package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class RoundsTest {
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void 양수가_아니면_Rounds_로_생성할_수_없다(String integer) {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Rounds(integer));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 숫자가_아니면_Rounds_로_생성할_수_없다(String integer) {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Rounds(integer));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000000000000000000000000"})
    void unsigned_int_이상의_수는_Rounds_로_생성할_수_없다(String integer) {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Rounds(integer));
    }

}
