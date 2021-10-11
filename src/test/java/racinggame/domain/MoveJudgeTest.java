package racinggame.domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;

public class MoveJudgeTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 정지(int returnValue) {
        try (final MockedStatic<Randoms> randomsMockedStatic = Mockito.mockStatic(Randoms.class)) {
            randomsMockedStatic.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(returnValue);

            assertThat(MoveJudge.judge()).isEqualTo(MoveStatus.STOP);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 이동(int returnValue) {
        try (final MockedStatic<Randoms> randomsMockedStatic = Mockito.mockStatic(Randoms.class)) {
            randomsMockedStatic.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(returnValue);

            assertThat(MoveJudge.judge()).isEqualTo(MoveStatus.MOVE);
        }
    }
}
