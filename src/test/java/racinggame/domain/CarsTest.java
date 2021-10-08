package racinggame.domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class CarsTest {
    @Test
    void race_실행시_car의_이동시도가_잘_실행되었는지_확인() {
        try (MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(4);
            Cars cars = new Cars("carA");
            cars.race();
            assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
        } catch (Throwable throwable) {
            fail(throwable.getMessage());
        }
    }
}