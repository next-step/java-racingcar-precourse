package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NameTest {


    @Test
    void 생성() {
        assertDoesNotThrow(() -> Name.of("abc").equals(Name.of("abc")));
    }
}