package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.RandomNumberMaker;

import static org.assertj.core.api.Assertions.*;
class CarTest {

    private static final int MOVE_NUMBER = 5;
    private static final int STOP_NUMBER = 2;

    @Test
    @DisplayName("Car 객체 생성 및 전진 테스트")
    void Car객체테스트() {
        String name_1 = "name_1";
        String name_2 = "name_2";

        Car car = new Car(name_1);
        Car car2 = new Car(name_2);

        assertThat(car.getDistance()).isEqualTo(0);
        assertThat(car2.getDistance()).isEqualTo(0);

        // move
        for (int i = 0; i < 10; i++) {
            int randomNum = RandomNumberMaker.makeNumber();
            car.moveOrNot(randomNum);
        }


        for (int i = 0; i < 3; i++) {
            int randomNum = RandomNumberMaker.makeNumber();
            car2.moveOrNot(randomNum);
        }

        assertThat(car.getDistance()).isGreaterThanOrEqualTo(0);
        assertThat(car.getDistance()).isLessThanOrEqualTo(10);
        assertThat(car.getName()).isEqualTo("name_1");

        assertThat(car2.getDistance()).isGreaterThanOrEqualTo(0);
        assertThat(car2.getDistance()).isLessThanOrEqualTo(10);
        assertThat(car2.getName()).isEqualTo("name_2");
    }

    @ValueSource(strings = {"name_1", "name_2"})
    @ParameterizedTest
    @DisplayName("차에 이름을 부여하는 기능 테스트")
    void 차이름(String name) {
        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("입력값이 4이상이면 전진하는 기능 검증")
    void name() {
        Car car = new Car("");
        assertThat(car.getDistance()).isEqualTo(0);
        car.moveOrNot(4);
        car.moveOrNot(6);
        car.moveOrNot(1);
        car.moveOrNot(2);
        assertThat(car.getDistance()).isEqualTo(2);

        car = new Car("");
        assertThat(car.getDistance()).isEqualTo(0);
        car.moveOrNot(9);
        car.moveOrNot(8);
        car.moveOrNot(7);

        assertThat(car.getDistance()).isEqualTo(3);
    }

    @DisplayName("입력값이 3이하면 멈추는 기능 검증")
    @Test
    void carStop() {
        Car car = new Car("");
        assertThat(car.getDistance()).isEqualTo(0);
        car.moveOrNot(STOP_NUMBER);
        assertThat(car.getDistance()).isEqualTo(0);

        car = new Car("");
        assertThat(car.getDistance()).isEqualTo(0);
        car.moveOrNot(STOP_NUMBER);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("차 위치를 String으로 리턴")
    void 거리를문자열로표시() {
        Car car = new Car("test_1");
        car.moveOrNot(MOVE_NUMBER);
        car.moveOrNot(MOVE_NUMBER);
        car.moveOrNot(MOVE_NUMBER);
        assertThat(car.getDistanceByString()).isEqualTo("---");

        car = new Car("test_2");
        car.moveOrNot(MOVE_NUMBER);
        car.moveOrNot(MOVE_NUMBER);
        assertThat(car.getDistanceByString()).isEqualTo("--");
    }
}