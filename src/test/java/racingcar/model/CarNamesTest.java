package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNamesTest {
    @DisplayName("이름이 ,로 분리되는지 테스트")
    @Test
    void name_split() {
        String input = "a,b,c";

        CarNames carNames = new CarNames(input);

        assertThat(carNames.getNames()).hasSize(3);
        assertThat(carNames.getNames().get(0).getName()).isEqualTo("a");
        assertThat(carNames.getNames().get(1).getName()).isEqualTo("b");
        assertThat(carNames.getNames().get(2).getName()).isEqualTo("c");
    }
}
