package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @DisplayName("입력된 자동차 대수가 1대 이하인 경우 예외처리")
    @Test
    void 입력된_자동차_대수가_1대_이하인_경우() {
        Car pobi = new Car("pobi");
        assertThatThrownBy(() -> new Cars(Arrays.asList(pobi)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 2대 이상 입력해주세요.");
    }

    @DisplayName("입력된 자동차 이름이 중복인 경우 예외처리")
    @Test
    void 입력된_자동차_이름이_중복인_경우() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");

        assertThatThrownBy(() -> new Cars(Arrays.asList(pobi, crong, pobi)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }

    @DisplayName("우승자가 2명 이상인 경우")
    @Test
    void getWinners() {
        Car pobi = new Car("pobi", 3);
        Car crong = new Car("crong", 3);
        Car honux = new Car("honux", 2);
        Cars cars = new Cars(Arrays.asList(pobi, crong, honux));

        assertThat(cars.getWinners()).containsExactly(pobi, crong);
    }

    @DisplayName("우승자가 1명인 경우")
    @Test
    void getWinner() {
        Car pobi = new Car("pobi", 3);
        Car crong = new Car("crong", 2);
        Car honux = new Car("honux", 2);
        Cars cars = new Cars(Arrays.asList(pobi, crong, honux));

        assertThat(cars.getWinners()).containsExactly(pobi);
    }
}
