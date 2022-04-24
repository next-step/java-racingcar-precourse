package racingcar.domain.racing.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.racing.constant.TestConstant.LOCATION_INCREMENT;
import static racingcar.domain.racing.constant.TestConstant.MOVING_FORWARD;
import static racingcar.domain.racing.constant.TestConstant.ORIGINAL_LOCATION;
import static racingcar.domain.racing.constant.TestConstant.STOP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.racing.car.accelerator.Accelerator;

public class CarTest {
    private final String VALID_CAR_NAME = "다섯자이하";
    private final String INVALID_CAR_NAME = "여섯자이상임";

    @Nested
    @DisplayName("자동차 이름 유효성 검사")
    class 자동차_이름_유효성_검사 {
        @Test
        @DisplayName("이름은 5자 이하만 가능하다")
        void 이름은_5자_이하만_가능하다() {
            Car car = Car.of(VALID_CAR_NAME, ORIGINAL_LOCATION);
            assertThat(car).isNotNull();
        }

        @Test
        @DisplayName("이름이 6자 이상이면 예외처리 한다")
        void 이름이_6자_이상이면_예외처리_한다() {
            assertThatThrownBy(() -> Car.of(INVALID_CAR_NAME, ORIGINAL_LOCATION)).isInstanceOf(
                    IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("자동차 위치값 변화 검사")
    class 자동차_위치값_변화_검사 {
        private Accelerator accelerator;
        private Car car;

        @BeforeEach
        void setUp() {
            car = Car.of(VALID_CAR_NAME, ORIGINAL_LOCATION);
        }

        @Nested
        @DisplayName("전진 검사")
        class 전진_검사 {
            @BeforeEach
            void setUp() {
                accelerator = Accelerator.from(MOVING_FORWARD);
            }

            @Test
            @DisplayName("값이 4 이상일 경우 전진한다")
            void 값이_4_이상일_경우_전진한다() {
                assertThat(car.accelerate(accelerator).getLocation()).isEqualTo(ORIGINAL_LOCATION + LOCATION_INCREMENT);
            }
        }

        @Nested
        @DisplayName("정지 검사")
        class 정지_검사 {
            @BeforeEach
            void setUp() {
                accelerator = Accelerator.from(STOP);
            }

            @Test
            @DisplayName("값이 3 이하일 경우 멈춘다")
            void 값이_3_이하일_경우_멈춘다() {
                assertThat(car.accelerate(accelerator).getLocation()).isEqualTo(ORIGINAL_LOCATION);
            }
        }
    }
}
