package racingcar.domainTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Position;
import racingcar.domain.car.Record;
import racingcar.domain.name.Name;
import racingcar.domain.name.Names;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCars {

    Cars cars;
    Record record;

    @BeforeEach
    void setup() {
        cars = new Cars(new Names("하하1,하하2,하하3"));
    }

    @Test
    @DisplayName("자동차들은 하나 이상이여야 한다")
    void 자동차들은_하나_이상이여야_한다() {
        assertThat(Arrays.asList(cars).size()).isEqualTo(1);
    }

    @Test
    @DisplayName("move cars")
    void move_cars() {
        // given
        System.out.println("cars = " + cars);
        // when then
    }
}
