package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car mycar;

    @BeforeEach
    void setUp() {
        mycar = new Car(new Name("mycar"), new Position(2));
    }

    @Test
    void 자동차를_출력할_때_자동차_이름과_현재_위치를_출력할_수_있다() {
        assertThat(mycar.printCurrentPosition()).isEqualTo("mycar : --");

        Car car = new Car(new Name("car"), new Position(0));
        assertThat(car.printCurrentPosition()).isEqualTo("car : ");
    }

    @Test
    void 입력받은_위치값과_자동차_위치값_중에_가장_큰_위치값을_반환한다() {
        assertThat(mycar.getMaxPosition(new Position(1))).isEqualTo(new Position(2));
        assertThat(mycar.getMaxPosition(new Position(2))).isEqualTo(new Position(2));
        assertThat(mycar.getMaxPosition(new Position(3))).isEqualTo(new Position(3));
    }

    @Test
    void 우승자_확인을_할_수_있다() {
        assertThat(mycar.isWinner(new Position(2))).isTrue();
        assertThat(mycar.isWinner(new Position(3))).isFalse();
    }
}
