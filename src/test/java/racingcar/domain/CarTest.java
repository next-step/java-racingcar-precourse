package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("Car Name 저장 확인")
    @Test
    public void Car_name_저장_확인() {
        // given // when
        Car car = new Car(new CarName("tico"));

        // then
        assertThat(car.getCarName()).isEqualTo("tico");
    }

    @Test
    @DisplayName("인스턴스 생성 시 이동거리 값 0 확인")
    public void 이동거리_초기화_확인() {
        // given // when
        Car car = new Car(new CarName("tico"));

        // then
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @DisplayName("Accelerator의 power가 4이상일 때 전진")
    @Test
    public void power_4이상_전진_테스트() {
        // given
        Car car = new Car(new CarName("tico"));
        Accelerator accelerator = new Accelerator(4);

        // when
        car.move(accelerator);

        // then
        assertThat(car.getDistancePrintMessage()).isEqualTo("-");
    }

    @DisplayName("Accelerator의 power가 3이하일 때 정지")
    @Test
    public void power_3이하_정지_테스트() {
        // given
        Car car = new Car(new CarName("tico"));
        Accelerator accelerator = new Accelerator(3);

        // when
        car.move(accelerator);

        // then
        assertThat(car.getDistancePrintMessage()).isEqualTo("");
    }
}
