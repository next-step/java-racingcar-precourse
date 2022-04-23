package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarListTest {
    @Test
    void 게임참여_차량_리스트_생성테스트() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("dolbi");
        List<Car> list = new ArrayList<>();
        list.add(car1);
        list.add(car2);
        // when
        CarList carList = new CarList(list);
        // then
        assertThat(carList.getCarByIndex(0).getCarName()).isEqualTo("pobi");
        assertThat(carList.getCarByIndex(1).getCarName()).isEqualTo("dolbi");
    }
}
