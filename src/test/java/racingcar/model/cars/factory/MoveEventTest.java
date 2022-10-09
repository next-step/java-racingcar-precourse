package racingcar.model.cars.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.only;

import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.MockedStatic;

public class MoveEventTest {
    @Test
    void 숫자_변환() {
        int[] values = new int[]{0, 1, 9};
        for (int expected : values) {
            assertThat(MoveEvent.of(expected).get()).isEqualTo(expected);
        }
    }

    @Test
    void 숫자_변환하면_유효성_검증_수행() {
        int value = 0;
        try (MockedStatic<MoveEventValidator> mock = mockStatic(MoveEventValidator.class)) {
            mock.when(() -> MoveEventValidator.assertValid(value)).thenAnswer(Answers.RETURNS_DEFAULTS);

            MoveEvent.of(value);

            mock.verify(() -> MoveEventValidator.assertValid(value), only());
        }
    }
}
