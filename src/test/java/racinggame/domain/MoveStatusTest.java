package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

public class MoveStatusTest {
    @DisplayName("랜덤값이 주어졌을 때 올바른 이동상태를 반환하는지 테스트")
    @Test
    void createRandom_success() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(0, 3, 4, 9);

            assertThat(MoveStatus.createRandom()).isEqualTo(MoveStatus.STOP);
            assertThat(MoveStatus.createRandom()).isEqualTo(MoveStatus.STOP);
            assertThat(MoveStatus.createRandom()).isEqualTo(MoveStatus.FORWARD);
            assertThat(MoveStatus.createRandom()).isEqualTo(MoveStatus.FORWARD);
        }
    }

    @DisplayName("전진 상태를 제대로 확인하는지 테스트")
    @Test
    void isForward_success() {
        assertThat(MoveStatus.FORWARD.isForward()).isEqualTo(true);
        assertThat(MoveStatus.STOP.isForward()).isEqualTo(false);
    }
}
