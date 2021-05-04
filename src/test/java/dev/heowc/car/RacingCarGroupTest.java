package dev.heowc.car;

import dev.heowc.condition.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("경주차들의 그룹에 대해 테스트한다.")
class RacingCarGroupTest {

    public static final Condition CONDITION = Condition.of(4);

    @DisplayName("구분자(,)로 경주자들의 그룹을 만들 수 있다.")
    @Test
    void successfulCreate() {
        final String carNames = "a,b,c";
        final String[] carNameArg = carNames.split(",");

        final RacingCarGroup group = RacingCarGroup.create(carNames, CONDITION);
        for (int i = 0; i < carNameArg.length; i++) {
            final RacingCar it = group.cars().get(i);
            assertThat(it.getName()).isEqualTo(carNameArg[i]);
        }
    }

    @DisplayName("올바르지 않은 구분자(,)로 경주자들의 그룹을 만들 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {",a", "a,,b"})
    void failureCreate(String carNames) {
        assertThatThrownBy(() -> {
            RacingCarGroup.create(carNames, CONDITION);
        }).isInstanceOf(NullPointerException.class).hasMessage("name is empty");
    }
}