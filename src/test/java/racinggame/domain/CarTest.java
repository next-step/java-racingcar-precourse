package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName(value = "1~9의 랜덤값을 가져오는가")
    @RepeatedTest(value = 5, name = "실행횟수 {currentRepetition}/{totalRepetitions}")
    public void 랜덤값을가져오니1_9() {
        Car car = new Car("pobi");
        assertThat(car.getRandomNo()).isGreaterThan(0).isLessThan(10);
    }

    @Test
    @DisplayName(value = "이름이 5글자 이상일때, 오류 발생하는가")
    public void 글자5글자이상오류() {
        assertThatThrownBy(() -> {
            new Car("fighting!");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName(value = "4 이상일 때 전진하는가")
    public void 전진하니() {
        Car car = new Car("pobi") {
            @Override
            protected int getRandomNo() {
                return 4;
            }
        };
        car.move();
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName(value = "3 이하일 때 정지하는가")
    public void 정지하니() {
        Car car = new Car("pobi") {
            @Override
            protected int getRandomNo() {
                return 3;
            }
        };
        car.move();
        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }
}