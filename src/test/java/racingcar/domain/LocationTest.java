package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LocationTest {
    @Test
    @DisplayName("Location 이 정상 증가하는지 확인")
    void increase_test() {
        Location location = new Location();
        location.apply(true);
        assertThat(location.getX()).isEqualTo(1);
    }

    @Test
    @DisplayName("Location x값 정상적으로 print 하는지 확인")
    void print_test() {
        Location location = new Location();
        location.apply(true);
        assertThat(location.print()).isEqualTo("-");
    }
}
