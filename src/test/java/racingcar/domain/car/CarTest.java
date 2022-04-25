package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.accelpower.AccelPowerStrategy;

public class CarTest {

    private Car car;

    @BeforeEach
    void setup(){
        //given
        car = new Car("Test");
    }

    @Test
    @DisplayName("차량 이름 확인")
    void 차량_이름_확인() {
        //then
        assertThat(car.getName()).isEqualTo("Test");
    }

    @Test
    @DisplayName("주어진 값에 대해 차 정지 확인")
    void 차량_정지_확인() {
        //when
        car.move(new AccelPowerStrategy() {
            @Override
            public boolean isMove() {
                return false;
            }
        });

        //then
        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("주어진 값에 대해 차 움직임 확인")
    void 차량_움직임_확인() {
        //when
        car.move(new AccelPowerStrategy() {
            @Override
            public boolean isMove() {
                return true;
            }
        });

        //then
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

}
