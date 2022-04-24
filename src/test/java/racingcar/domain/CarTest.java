package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import racingcar.common.GameConfig;

public class CarTest {
    Car car;

    @BeforeEach
    void init() {
        car = new Car("pobi", GameConfig.BASE_CAR_POSITION);
    }

    @Test
    @DisplayName("랜덤숫자_생성_범위_0_9_체크")
    @RepeatedTest(1000)
    void 랜덤숫자_생성_범위_0_9_체크() {
        int no = car.generateRandomNo(GameConfig.MIN_RANDOM_NO, GameConfig.MAX_RANDOM_NO);
        assertThat(no).isBetween(GameConfig.MIN_RANDOM_NO, GameConfig.MAX_RANDOM_NO);
    }

    @ParameterizedTest
    @DisplayName("랜덤값_4_미만_자동차_이동_체크")
    @ValueSource(ints = { 0, 1, 2, 3 })
    void 랜덤값_4_미만_자동차_이동_체크(int no) {
        assertThat(car.isGo(no)).isFalse();
    }

    @ParameterizedTest
    @DisplayName("랜덤값_4_이상_자동차_이동_체크")
    @ValueSource(ints = { 4, 5, 6, 7, 8, 9 })
    void 랜덤값_4_이상_자동차_이동_체크(int no) {
        assertThat(car.isGo(no)).isTrue();
    }

    @Test
    @DisplayName("자동차_위치_비교_체크")
    void 자동차_위치_비교_체크() {
        Car pobiCar = new Car("pobi", 2);
        Car toyoCar = new Car("toyo", 1);
        assertThat(pobiCar.compareTo(toyoCar)).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차_위치_동일할때_비교_체크")
    void 자동차_위치_동일할때_비교_체크() {
        Car pobiCar = new Car("pobi", 2);
        Car toyoCar = new Car("toyo", 2);
        assertThat(pobiCar.compareTo(toyoCar)).isEqualTo(-1);
    }
}
