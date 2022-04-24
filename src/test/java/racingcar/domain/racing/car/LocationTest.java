package racingcar.domain.racing.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LocationTest {
    @Test
    void 위치값에_거리를_추가할_수_있다() {
        assertThat(Location.from(3).add(2)).isEqualTo(Location.from(5));
    }
}
