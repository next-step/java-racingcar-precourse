package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.code.NameErrorCode;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = { "소나타", "아이오닉" })
    void 이름_5자리_이하(String name) {
        assertEquals(new Name(name).getName(), name);
    }

    @ParameterizedTest
    @ValueSource(strings = { "롤스로이스 고스트", "람보르기니 우라칸" })
    void 이름_5자리_초과(String name) {
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> { new Name(name); });

        assertEquals(NameErrorCode.LENGTH.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 이름_NULL_확인(String name) {
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
            () -> { new Name(name); });

        assertEquals(NameErrorCode.NULL.getMessage(), exception.getMessage());
    }
    
    @ParameterizedTest
    @ValueSource(strings = { " ", "   " })
    void 이름_공백_확인(String name) {
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
            () -> { new Name(name); });

        assertEquals(NameErrorCode.EMPTY.getMessage(), exception.getMessage());
    }
}
