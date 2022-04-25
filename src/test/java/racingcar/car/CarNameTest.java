package racingcar.car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @Test
    void 동일한_문자열을_가지고_있다면_동등한_객체이다() {
        CarName left = CarName.of("abc");
        CarName right = CarName.of("abc");

        assertEquals(left, right);
    }

    @Test
    void 자동차의_이름은_한_글자_미만일_수_없다() {
        assertThrows(IllegalArgumentException.class,
                () -> CarName.of(""));
    }

    @Test
    void 자동차의_이름은_다섯_글자를_초과할_수_없다() {
        assertThrows(IllegalArgumentException.class,
                () -> CarName.of("abcdef"));
    }

    @Test
    void 한_글자_이상_다섯_글자_이하의_자동차_이름을_지정할_수_있다() {
        assertDoesNotThrow(() -> CarName.of("a"));
        assertDoesNotThrow(() -> CarName.of("ab"));
        assertDoesNotThrow(() -> CarName.of("abc"));
        assertDoesNotThrow(() -> CarName.of("abcd"));
        assertDoesNotThrow(() -> CarName.of("abcde"));
    }

}