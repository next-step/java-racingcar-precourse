package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.Location;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @Test
    @DisplayName("입력한 자동차 이름 개수만큼 Car 객체 생성되는지 확인")
    void createBatch() {
        List<Car> cars = Car.createBatch(new CarNames(new String[]{"pobi", "woni", "jun"}));

        assertThat(cars).hasSize(3);
    }

    @Test
    @DisplayName("입력한 자동차 이름대로 Car 객체 생성되는지 확인")
    void createBatchCarName() {
        List<Car> cars = Car.createBatch(new CarNames(new String[]{"pobi", "woni", "jun"}));

        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
    }

    @Test
    @DisplayName("우승 여부 확인")
    void isWinningLocation() {
        int winningLocation = 3;
        assertThat(new Car("star", new Location(3)).getLocation()).isEqualTo(winningLocation);
        assertThat(new Car("star", new Location(3)).getLocation()).isEqualTo(winningLocation);
    }
}