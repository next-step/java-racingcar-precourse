package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    public static final int MIN_MOVE_COUNT = 0;
    public static final int MAX_MOVE_COUNT = 9;
    public static final boolean MOVE = true;
    public static final boolean STOP = false;

    @ParameterizedTest
    @DisplayName("자동차 이름 테스트")
    @ValueSource(strings = {"abcde", "가나다라마", "12345"})
    void 자동차_이름_5자이하_정상(String name) {

        Car car = new Car(name);

        assertThat(car.getName().length() <= 5).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 테스트")
    @ValueSource(strings = {"abcedf", "가나다라마바사", "123456"})
    void 자동차_이름_5자초과_비정상(String name) {

        assertThatThrownBy(() -> {
            Car car = new Car(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이동거리 생성 테스트")
    void 자동차_이동거리_생성_정상() {
        Car car = new Car("테스트");
        car.setMoveCount();
        int moveCount = car.getMoveCount();
        assertThat(moveCount >= MIN_MOVE_COUNT && moveCount <= MAX_MOVE_COUNT).isEqualTo(true);
    }

    @Test
    @DisplayName("자동차 이동여부 생성 정상 테스트")
    void 자동차_이동여부_정상() {
        Car car = new Car("테스트");
        car.setMoveCount();
        boolean moveOrStop = car.getMoveOrStop();
        assertThat(moveOrStop).isIn(MOVE, STOP);
    }

    @Test
    @DisplayName("자동차 이동 정상 테스트")
    void 자동차_이동_정상() {
        Car car = new Car("테스트");
        int prev = car.getCarPosition();
        car.setMoveCount();
        car.moveCar();
        int after = car.getCarPosition();

        assertThat(((car.getMoveCount() >= 4) && (prev < after)) == car.getMoveOrStop()).isEqualTo(true);
    }
}
