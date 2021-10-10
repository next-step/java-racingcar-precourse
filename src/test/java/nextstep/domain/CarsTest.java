package nextstep.domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class CarsTest {

    @Test
    void 자동차_이동() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(4, 3, 4);
            Cars cars = new Cars("pobi,crong,honux");
            List<MoveResult> results = cars.move();
            assertThat(results).contains(
                    new MoveResult("pobi", 1),
                    new MoveResult("crong", 0),
                    new MoveResult("honux", 1));
        }
    }
}