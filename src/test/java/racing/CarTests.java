package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.model.Car;
import racing.model.strategy.RandomMoving;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTests {

    private static final String INVALID_VALUE_EXCEPTION_MESSAGE = "1~5자 이내의 이름을 입력하십시오.";
    private static final String INVALID_RANDOM_MOVING_STRATEGY = "자동차 (랜덤)이동 범위를 설정하십시오.";
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MIN_MOVING_RANGE = 4;

    private Car car;

    @BeforeEach
    public void 자동차_초기화() {
        car = new Car();
    }

    @DisplayName("자동차 생성")
    @Test
    public void 자동차_생성() {
        assertThat(car.getRecordResult())
                .isNotNull()
                .isEqualTo(0);
    }

    @DisplayName("자동차 이름부여")
    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    public void 자동차_이름부여(String name) {
        car = new Car(name);

        assertThat(car.getName())
                .isNotNull()
                .isEqualTo(name);
    }

    @DisplayName("자동차 이름부여 실패")
    @ParameterizedTest
    @ValueSource(strings = {"anthony"})
    public void 자동차_이름부여_실패(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_VALUE_EXCEPTION_MESSAGE);
    }

    @DisplayName("자동차 이동")
    @Test
    public void 자동차_이동() {
        car.move(new RandomMoving(MAX_RANDOM_VALUE, 0));

        assertThat(car.getRecordResult())
                .isNotNull()
                .isGreaterThanOrEqualTo(0);
    }

    @DisplayName("자동차 정지")
    @Test
    public void 자동차_정지() {
        car.move(new RandomMoving(MAX_RANDOM_VALUE, 10));

        assertThat(car.getRecordResult())
                .isNotNull()
                .isLessThanOrEqualTo(10);
    }

    @DisplayName("자동차 이동 실패")
    @Test
    public void 자동차_이동_실패() {
        assertThatThrownBy(() -> car.move(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANDOM_MOVING_STRATEGY);
    }

    @DisplayName("자동차 이동범위 생성")
    @Test
    public void 자동차_이동범위_생성() {
        RandomMoving randomMoving = new RandomMoving(MAX_RANDOM_VALUE, MIN_MOVING_RANGE);
        assertThat(randomMoving.range())
                .isNotNull()
                .isGreaterThanOrEqualTo(1)
                .isLessThanOrEqualTo(9);
    }

    @DisplayName("자동차 이동가능 판단")
    @Test
    public void 자동차_이동가능_판단() {
        RandomMoving randomMoving = new RandomMoving(MAX_RANDOM_VALUE, 0);
        assertThat(randomMoving.isForward(0))
                .isTrue();
    }

}
