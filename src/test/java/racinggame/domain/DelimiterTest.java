package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class DelimiterTest {

    @Test
    @DisplayName("차 이름을 분리한다")
    void separate_car_names() {
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