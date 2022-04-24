package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class DelimiterTest {

    @Test
    void 차_이름_분리_검증() {
        String names = "shin,han,study";
        List<CarName> carNames = Delimiter.separateCarNames(names);
        List<CarName> compareCarNames =
                Arrays.asList(new CarName("shin"), new CarName("han"), new CarName("study"));

        assertAll(
                () -> assertThat(carNames.size()).isEqualTo(3),
                () -> assertThat(carNames).isEqualTo(compareCarNames)
        );
    }
}