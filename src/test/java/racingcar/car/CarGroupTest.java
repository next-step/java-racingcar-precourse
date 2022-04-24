package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("CarGroup에 대해 테스트한다.")
class CarGroupTest {

    @DisplayName("콤마(,)를 구분자로 Car리스트를 갖는 CarGroup을 생성한다.")
    @Test
    void successfulCreatingCarGroup() {
        final CarGroup carGroup = CarGroup.of("1,2,3,4,5");
        assertThat(carGroup.asList()).size().isEqualTo(5);
    }

    @ParameterizedTest(name = "올바르지 않은 입력값으로 CarGroup을 생성하는데 실패한다. value={0}")
    @NullAndEmptySource
    @ValueSource(strings = ",")
    void failureCreatingCarGroup(String value) {
        assertThatThrownBy(() -> {
            CarGroup.of(value);
        }).isInstanceOf(InvalidCarNameOfCarGroupException.class);
    }
}
