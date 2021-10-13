package racinggame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("RacinggameResult Model 테스트")
class RacinggameResultTest {

    @Test
    @DisplayName("RacinggameResult 생성 확인")
    void createRacinggameResult() {
        // given // when
        RacinggameResult racinggameResult = new RacinggameResult.Builder()
                .firstPlace("test")
                .build();

        // then
        assertAll(
                () -> assertThat(racinggameResult).isNotNull(),
                () -> assertThat(racinggameResult).isInstanceOf(RacinggameResult.class),
                () -> assertThat(racinggameResult.getFirstPlace()).isEqualTo("test")
        );
    }
}
