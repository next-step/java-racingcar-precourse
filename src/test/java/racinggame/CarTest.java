package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private Car car;

    @BeforeEach
    void setup() {
        car = new Car("a"); // 카운트는 자동 초기화
    }

    @Test
    void 차_전진() {
        int examRandomPoint = 4;
        car.decideMove(examRandomPoint);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @Test
    void 차_멈춤() {
        int examRandomPoint = 1;
        car.decideMove(examRandomPoint);
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    void 차_이름_5자_이상_테스트() {
        assertThatThrownBy(()-> {
            car = new Car("abcasdlkfj");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자를 초과");
    }

    @Test
    void 차_이름_null_테스트() {
        assertThatThrownBy(()-> {
            car = new Car(null);
        }).isInstanceOf(NullPointerException.class)
                .hasMessageContaining("이름을 입력");
    }
}
