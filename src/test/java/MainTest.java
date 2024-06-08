import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @Test
    public void shouldDetermineWinnersBasedOnMaxPosition() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        car1.move(5); // 4 이상
        car1.move(5); // 4 이상
        car2.move(3); // 3 이하
        car3.move(5); // 4 이상

        List<Car> cars = Arrays.asList(car1, car2, car3);
        List<String> winners = Main.getWinners(cars);

        assertThat(winners).containsExactly("pobi");
    }


}