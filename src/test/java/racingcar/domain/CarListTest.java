package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("차량 리스트 테스트")
class CarListTest {

    @Test
    @DisplayName("01_차량 이름 중복 테스트")
    public void car_name_duplicate() {
        Car car1 = new Car(new CarName("car1"));
        Car car2 = new Car(new CarName("car1"));
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        assertSimpleTest(() -> assertThatThrownBy(() -> new CarList(carList))
                .isInstanceOf(IllegalArgumentException.class));
    }

}