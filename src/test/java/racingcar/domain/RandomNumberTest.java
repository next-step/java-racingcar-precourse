package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    @Test
    @DisplayName("랜덤넘버 검증")
    void verifying_rando_number(){
        assertThat(new RandomNumber()).isNotNull();
    }
}
