package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.exception.RacingGameErrorCode;
import racinggame.exception.RacingGameException;
import racinggame.utils.Message;

public class NameTest {
    @DisplayName("이름이 5글자 초과 또는 null이나 비어있을 때 에러 던지는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void constructName_throwsErrorWhenNameIsNullOrEmptyOrHigherThan5(String name) {
        assertThatExceptionOfType(RacingGameException.class)
            .isThrownBy(() -> new Name(name))
            .withMessageContaining(RacingGameErrorCode.INVALID_CAR_NAME.getMessage());
    }

    @DisplayName("이름을 출력하기 위한 메시지 생성 테스트")
    @Test
    void makeNameMessage_success() {
        Name name = new Name("name");
        assertThat(name.makeNameMessage()).isEqualTo(new Message("name"));
    }
}
