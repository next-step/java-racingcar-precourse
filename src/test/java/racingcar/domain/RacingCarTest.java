package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar(new RacingCarName("Tom"));
    }

    @Test
    @DisplayName("전진 테스트")
    void 전진() {
        racingCar.race(new MoveNumberForTest(4));
        Location location = racingCar.getLocation();

        assertThat(location.equals(new Location(1))).isTrue();
    }

    @Test
    @DisplayName("전진 2회 테스트")
    void 전진2회() {
        racingCar.race(new MoveNumberForTest(4));
        racingCar.race(new MoveNumberForTest(4));
        Location location = racingCar.getLocation();

        assertThat(location.equals(new Location(2))).isTrue();
    }

    @Test
    @DisplayName("멈춤 테스트")
    void 멈춤() {
        racingCar.race(new MoveNumberForTest(0));
        Location location = racingCar.getLocation();

        assertThat(location.equals(new Location(0))).isTrue();
    }

    @Test
    @DisplayName("멈춤 테스트")
    void 전진1회멈춤() {
        racingCar.race(new MoveNumberForTest(5));
        racingCar.race(new MoveNumberForTest(0));
        Location location = racingCar.getLocation();

        assertThat(location.equals(new Location(1))).isTrue();
    }

    @Test
    @DisplayName("전진 값이 잘못 입력된 경우 테스트")
    void 입력_예외() {
        RacingCar racingCar = new RacingCar(new RacingCarName("Yomni"));

        assertThatThrownBy(() -> racingCar.race(new MoveNumberForTest(-1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Location.ERROR_MSG_WRONG_NO);
        assertThatThrownBy(() -> racingCar.race(new MoveNumberForTest(10)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Location.ERROR_MSG_WRONG_NO);
    }

    @Test
    @DisplayName("자동차 이름 테스트")
    void 자동차이름() {
        RacingCarName racingCarName = racingCar.getRacingCarName();

        assertThat(racingCarName.equals(new RacingCarName("Tom"))).isTrue();
        assertThat(racingCarName.equals(new RacingCarName("Yomni"))).isFalse();
    }

    @Test
    @DisplayName("자동차 equal 테스트")
    void 자동차_equal() {
        RacingCar compareCar = new RacingCar(new RacingCarName("Tom"));

        assertThat(racingCar.equals(compareCar)).isTrue();
    }

    @Test
    @DisplayName("자동차 이름을 6자 테스트")
    void 자동차이름_길이_예외_테스트() {
        assertThatThrownBy(() -> new RacingCar(new RacingCarName("stupid")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarName.ERROR_MSG_OVER_LENGTH_LIMIT);
    }

    @Test
    @DisplayName("자동차이름 null 혹은 공백 예외 테스트")
    void 자동차이름_공백_예외_테스트() {
        assertThatThrownBy(() -> new RacingCar(new RacingCarName("")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarName.ERROR_MSG_BLANK_OR_NULL);

        assertThatThrownBy(() -> new RacingCar(new RacingCarName(null)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarName.ERROR_MSG_BLANK_OR_NULL);
    }

    class MoveNumberForTest extends MoveNumber {
        private final int moveNumber;

        public MoveNumberForTest(int moveNumber) {
            this.moveNumber = moveNumber;
        }

        public int getMoveNumber() {
            return this.moveNumber;
        }
    }
}
