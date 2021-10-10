package nextstep.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars("pobi,crong,honux", new FakeRandom());
    }

    @Test
    void 자동차_이동() {
            List<MoveResult> results = cars.move();
            assertThat(results).contains(
                    new MoveResult("pobi", 1),
                    new MoveResult("crong", 0),
                    new MoveResult("honux", 1));
    }

    @Test
    void 최대_이동거리() {
        cars.move();
        int max = cars.maxDistance();
        assertThat(max).isEqualTo(1);
    }

    @Test
    void 우승자_이름들() {
        cars.move();
        String winners = cars.getWinners();
        assertThat(winners).isEqualTo("pobi,honux");
    }
}