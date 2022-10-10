package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 엔진 도메인 테스트")
class EngineTest {

    @ParameterizedTest(name = "{displayName} [input : {arguments}]")
    @CsvSource(value = {"0:STOP", "3:STOP", "4:FORWARD", "9:FORWARD"}, delimiter = ':')
    @DisplayName("0이상 3이하는 STOP, 5이상 9이하는 FORWARD")
    void getActionType(int input, ControlType expected) {
        try (MockedStatic<Randoms> mockedStatic = Mockito.mockStatic(Randoms.class)) {
            // given
            mockedStatic.when(() -> Randoms.pickNumberInRange(Engine.MIN_OF_RANGE, Engine.MAX_OF_RANGE))
                    .thenReturn(input);

            // when
            ControlType controlType = Engine.getControlType();

            // then
            assertThat(controlType).isEqualTo(expected);
        }
    }
}
