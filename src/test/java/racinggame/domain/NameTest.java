package racinggame.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {

    @Test
    void 생성() {
        String name = "abc";

        assertEquals(Name.of(name), Name.of(name));
        assertEquals(Name.of(Name.of(name)), Name.of(name));
        assertEquals(Name.of(name).value(), name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "kimdonggyu", "aaaaaaaaa"})
    void 다섯글자를_넘을_수_없다(final String name) {
        assertThrows(NoSuchElementException.class, () -> Name.of(name));
    }
}