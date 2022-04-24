package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarListTest {

    @Test
    @DisplayName("자동차리스트 객체 생성시 자동차가 없는 경우 체크")
    public void 자동차리스트_객체_생성시_유효성검사() {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarList(Collections.emptyList()));
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차들")
    public void 자동차리스트에서_가장_멀리_이동한_자동차_추출() {
        List<Car> cars = new ArrayList<>();
        cars.add(getTestCar("test1", 2));
        cars.add(getTestCar("test2", 3));
        cars.add(getTestCar("test3", 5));
        cars.add(getTestCar("test4", 1));

        CarList carList = new CarList(cars);
        List<Car> headCarList = carList.getHeadCarList();

        assertEquals(headCarList.get(0).getCarName(), "test3");
    }

    private Car getTestCar(String carName, int behaviorNumber) {
        Car car = new Car(new CarName(carName));
        car.changeDistance(new CarBehavior(behaviorNumber));

        return car;
    }

}
