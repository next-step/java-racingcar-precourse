package domain.race.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    Car car;

    @BeforeEach
    void setUpRace() {
        car = new Car("test");
    }

    @AfterEach
    void cleanRace() {
        car = null;
    }

    @Test
    @DisplayName("100번의 랜덤 전진 수행을 하게 되면 높은 확률로 car 의 position 은 0보다 크다.")
    void winnerTest() {
        for (int i = 0; i < 100; i++) {
            car.move();
        }

        Assertions.assertThat(car.getPosition()).isGreaterThan(0);
        // 아주 낮은 확률로 0인 경우 테스트를 실패할 수 있지만, 그 경우 print 에 찍힌 결과가 0 이어야 한다.
        System.out.println(car.getPosition());
    }

}