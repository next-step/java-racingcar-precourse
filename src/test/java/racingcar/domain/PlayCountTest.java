package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayCountTest {
    PlayCount playCount;

    @DisplayName("PlayCount validation 생성자 테스트")
    @Test
    void generator_test(){
        assertThatThrownBy(() -> playCount = new PlayCount("d"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도 횟수는 숫자여야 한다.");
        ;
    }
}