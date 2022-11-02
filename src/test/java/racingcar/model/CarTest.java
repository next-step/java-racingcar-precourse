package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("자동차_생성")
    void generate_car() {
        Car car = new Car(new CarName("crong"));
        assertThat(car.name()).isEqualTo("crong");
        assertThat(car.getPosition()).isEqualTo(new CarPosition(0));
    }

    @RepeatedTest(10)
    @DisplayName("자동차_이동")
    void move_car() {
        Car car = new Car(new CarName("crong"));
        car.move(new MockMovingStrategy());
        assertThat(car.getPosition().getPosition()).isLessThanOrEqualTo(1);
    }

    @Test
    @DisplayName("자동차_상태_이름_하이픈_반환")
    void car_status() {
        Car car = new Car(new CarName("crong"));
        car.move(new MockMovingStrategy());
        car.move(new MockMovingStrategy());
        assertThat(car.getState()).contains("crong : --");
    }

    @Test
    @DisplayName("자동차_이동_상태_비교")
    void car_compare_move_state() {
        Car crong = new Car(new CarName("crong"));
        crong.move(new MockMovingStrategy());
        crong.move(new MockMovingStrategy());
        Car honux = new Car(new CarName("honux"));
        honux.move(new MockMovingStrategy());
        assertThat(crong.maxPosition(honux.getPosition())).isEqualTo(crong.getPosition());
    }
}
