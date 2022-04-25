package racingcar.view.message;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {

    @DisplayName("거리는 -로 나타낸다")
    @ParameterizedTest
    @CsvSource(value = {"-1, ''", "0, ''", "1, -", "2, --", "3, ---"})
    void distance(int position, String expected) {

        //when
        Distance actual = Distance.from(position);

        //then
        assertThat(actual.get()).isEqualTo(expected);
    }
}
