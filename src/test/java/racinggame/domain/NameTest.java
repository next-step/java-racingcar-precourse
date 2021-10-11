package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {
    @DisplayName("이름이 5글자 이상 또는 null이나 비어있을 때 에러 던지는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void constructName_throwsErrorWhenNameIsNullOrEmptyOrHigherThan5(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Car(new Name(name)))
            .withMessageContaining("5글자 이상 또는 비어있는 이름으로 자동차를 생성할 수 없습니다.");
    }
}
