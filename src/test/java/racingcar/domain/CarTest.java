package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CarTest {

    @Test
    @DisplayName("자동차 생성, 이름 5자이하 테스트")
    void constructor() {
        Car car = new Car("  하스      ");
        assertThat(car.getName()).isEqualTo("하스");

        car = new Car("에스턴마틴");
        assertThat(car.getName()).isEqualTo("에스턴마틴");
    }

    @Test
    @DisplayName("유효하지 않은 이름")
    void invalidName() {
        invalidName(null);
        invalidName("");
        invalidName("   ");
        invalidName("레이싱포인트");
    }

    private void invalidName(String name) {
        assertThat(catchThrowable(() -> new Car(name)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("랜덤 코드에 따른 자동차 전진, 멈춤 테스트")
    void move() {
        Car car = new Car("메르세데스");

        car.move(MoveStatus.getStatus(new RandomNumber(0)));
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(MoveStatus.getStatus(new RandomNumber(3)));
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(MoveStatus.getStatus(new RandomNumber(4)));
        assertThat(car.getPosition()).isEqualTo(1);

        car.move(MoveStatus.getStatus(new RandomNumber(5)));
        assertThat(car.getPosition()).isEqualTo(2);

        car.move(MoveStatus.getStatus(new RandomNumber(2)));
        assertThat(car.getPosition()).isEqualTo(2);
    }

}