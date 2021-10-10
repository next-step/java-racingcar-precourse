package nextstep.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"javaji"})
    void 자동차_이름_5자_이내(String name) {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> new CarName(name));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 자동차_이름_null(String name) {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> new CarName(name));
    }

}