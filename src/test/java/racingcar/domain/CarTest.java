package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.RandomNumber;

public class CarTest {

    @Test
    @DisplayName("자동차 객체 생성 테스트")
    void car_generate_test() {
        Car car = new Car("one");

        assertThat(car.getName()).isEqualTo("one");
        assertThat(car.getDriven()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 주행 테스트 : 0~3 정지 테스트")
    void car_driven_stop_test() {
        Car car = new Car("one");

        RandomNumber randomNumber;

        do {
            randomNumber = new RandomNumber();
        } while(randomNumber.getNumber() >= 4);

        car.addDriven(randomNumber);

        assertThat(car.getDriven()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 주행 테스트 : 4~9 전진 테스트")
    void car_driven_go_test() {
        Car car = new Car("one");

        RandomNumber randomNumber;

        do {
            randomNumber = new RandomNumber();
        } while(randomNumber.getNumber() < 4);

        car.addDriven(randomNumber);

        assertThat(car.getDriven()).isEqualTo(1);
    }

}
