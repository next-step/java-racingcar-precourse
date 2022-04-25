package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.model.collection.CarGroups;

class CarTest {

    @Test
    void 자동차_이름_추가_정상() {
        Car car = new Car();
        car.setName("베뉴");
        assertThat(car.getName()).isEqualTo("베뉴");
    }

    @Test
    void 자동차_이름_추가_실패() {
        Car car = new Car();
        assertThatThrownBy(() ->
                car.setName(null)
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->
                car.setName("")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->
                car.setName("자동차자동차")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_전진_확인() {
        Car car = new Car("모닝");
        assertThat(car.getDrivingDistance().getDistance()).isZero();
        car.move(4);
        assertThat(car.getDrivingDistance().getDistance()).isEqualTo(1);
    }

    @Test
    void 자동차_정지_확인() {
        Car car = new Car("모닝");
        assertThat(car.getDrivingDistance().getDistance()).isZero();
        car.move(3);
        assertThat(car.getDrivingDistance().getDistance()).isZero();
    }

    @Test
    void 자동차_전진_정지_예외값_확인() {
        Car car = new Car("모닝");

        assertThatThrownBy(() -> {
            car.move(-1);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            car.move(10);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}