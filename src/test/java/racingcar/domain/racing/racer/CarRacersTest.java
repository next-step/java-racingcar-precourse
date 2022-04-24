package racingcar.domain.racing.racer;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.racing.constant.TestConstant.MOVING_FORWARD;
import static racingcar.domain.racing.constant.TestConstant.ORIGINAL_LOCATION;
import static racingcar.domain.racing.constant.TestConstant.STOP;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.racing.car.Car;
import racingcar.domain.racing.car.Cars;
import racingcar.domain.racing.car.accelerator.generator.ManualAcceleratorGenerator;
import racingcar.domain.racing.car.accelerator.generator.RandomAcceleratorGenerator;

public class CarRacersTest {
    @Test
    @DisplayName("레이스가 끝나면 레이스 결과로 CarRacers를 반환한다")
    void 레이스가_끝나면_레이스_결과로_CarRacers를_반환한다() {
        CarRacers carRacers = CarRacers.from(Cars.from("pobi,woni,jun"), RandomAcceleratorGenerator.create()).race();
        assertThat(carRacers).isNotNull();
    }

    @Nested
    @DisplayName("우승자 검사")
    class 우승자_검사 {
        private CarRacers carRacers;

        @BeforeEach
        void setUp() {
            Racer pobi = Racer.from(ManualAcceleratorGenerator.from(MOVING_FORWARD));
            Racer woni = Racer.from(ManualAcceleratorGenerator.from(MOVING_FORWARD));
            Racer jun = Racer.from(ManualAcceleratorGenerator.from(STOP));

            Car pobiCar = Car.of("pobi", ORIGINAL_LOCATION);
            Car woniCar = Car.of("woni", ORIGINAL_LOCATION);
            Car junCar = Car.of("jun", ORIGINAL_LOCATION);

            Map<Racer, Car> racerCarMap = new LinkedHashMap<>();
            racerCarMap.put(pobi, pobiCar);
            racerCarMap.put(woni, woniCar);
            racerCarMap.put(jun, junCar);

            carRacers = new CarRacers(racerCarMap).race();
        }

        @Test
        @DisplayName("레이스가 끝나고 우승한 자동차를 알 수 있다")
        void 레이스가_끝나고_우승한_자동차를_알_수_있다() {
            Winner winner = carRacers.getWinner();
            assertThat(winner).isNotNull();
            assertThat(winner.getWinners()).hasSize(2);
        }
    }


}
