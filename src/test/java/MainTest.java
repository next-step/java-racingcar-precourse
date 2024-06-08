import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MainTest {
    @Test
    public void shouldParseCarNamesSeparatedByComma() {
        String input = "pobi,woni,jun";
        List<Car> cars = Main.parseCarNames(input);
        assertThat(cars).extracting(Car::getName)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    public void shouldThrowExceptionWhenTrialCountIsLessThanOne() {
        assertThatThrownBy(() -> Main.validateTrialCount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }


}