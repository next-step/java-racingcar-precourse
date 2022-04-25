package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : choi-ys
 * @date : 2022-04-25 오전 2:15
 */
@DisplayName("Utils:CarNamesUtils")
class CarNamesUtilsTest {

    @Test
    @DisplayName("','를 기준으로 경주에 참여할 자동차 이름 분리")
    public void splitByComma() {
        // Given
        String namesByComma = "마카롱택시,카카오택시,우티,타다";

        // When
        String[] actual = CarNamesUtils.splitByComma(namesByComma);

        // Then
        assertThat(actual.length).isEqualTo(namesByComma.split(",").length);
    }
}