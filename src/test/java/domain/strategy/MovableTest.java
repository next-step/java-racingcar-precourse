package domain.strategy;

import domain.Car;
import domain.Moving;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class MovableTest {

    private Moving car;
    private int beforePos;

    @BeforeEach
    void setUp() {
        car = new Car("test");
        car.setMovableStrategy(new RacingCarStrategy());
        beforePos = car.getPos();
    }

    @Test
    @DisplayName("숫자에 따른 정상적인 이동확인 테스트")
    void 이동_확인_검증() {
        int beforePos = car.getPos();
        assertAll(
                () -> {
                    car.move(3);
                    assertThat(car.getPos()).isEqualTo(beforePos);
                },
                () -> {
                    car.move(4);
                    assertThat(car.getPos()).isEqualTo(beforePos + 1);
                }
        );
    }

    @Test
    @DisplayName("자동차 움직임 : 4턴동안 3번이동 1번 멈출경우 결과일치")
    void 자동차_움직임_4턴동안_3번이동_1번_멈출경우() {
        int[] arr = {8, 7, 2, 7};
        for (int i : arr) {
            car.move(i);
        }
        assertThat(car.getPos()).isEqualTo(beforePos + 3);

    }

    @Test
    @DisplayName("자동차 움직임 : 4턴동안 움직이지 않을 경우 결과일치")
    void 자동차_움직임_4턴동안_움직이지_않을경우() {
        int[] arr = {0, 1, 2, 3};
        for (int i : arr) {
            car.move(i);
        }
        assertThat(car.getPos()).isEqualTo(beforePos);

    }

    @Test
    @DisplayName("자동차 움직임 : 4턴동안 전부 이동시 결과일치")
    void 자동차_움직임_4턴동안_전부이동할_경우() {
        int[] arr = {4, 5, 6, 7};
        for (int i : arr) {
            car.move(i);
        }
        assertThat(car.getPos()).isEqualTo(beforePos + 4);

    }
}
