package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.PlayResult;
import racingcar.stategy.ForwardStrategy;
import racingcar.stategy.HoldStrategy;

import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RacingCarServiceTest {

    private Car myCar;
    private Cars racingCarList;

    @BeforeEach
    void setUp() {
        myCar = new Car("myCar", 0);
        racingCarList = new Cars("Thor,Hulk,Loki,Widow");
    }

    @DisplayName("자동차는 5글자자 이하의 이름을 갖는다.")
    @ParameterizedTest
    @ValueSource(strings = {"Thor", "Hulk", "Loki", "Widow"})
    void constructor(final String name) {
        assertNotNull(new Car(name, 0));
    }

    @DisplayName("자동차 이름은 5글자를 넘을 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"Disney", "Ironman", "Hawkeye"})
    void validateCarName(final String name) {
        assertThatThrownBy(() -> new Car(name, 0))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("자동차 이름은 쉼표(,)로 구분한다.")
    @ParameterizedTest
    @ValueSource(strings = "Thor,Hulk,Loki,Widow")
    void createCarList(final String names) {
        String[] carNames = names.split(",");
        for (int k = 0; k < carNames.length; k++) {
            assertNotNull(new Car(carNames[k], 0));
        }
    }

    @DisplayName("자동차가 전진한다.")
    @Test
    void go() {
        myCar.move(new ForwardStrategy());
        assertThat(myCar.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차가 움직이지 않는다.")
    @Test
    void hold() {
        myCar.move(new HoldStrategy());
        assertThat(myCar.getPosition()).isZero();
    }

    @DisplayName("random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.")
    @Test
    void randomMove() {
        final int randomNumber = pickNumberInRange(1, 9);
        if (randomNumber >= 4) {
            myCar.move(new ForwardStrategy());
            assertThat(myCar.getPosition()).isEqualTo(1);
        }
        if (randomNumber < 4) {
            myCar.move(new HoldStrategy());
            assertThat(myCar.getPosition()).isZero();
        }
    }

    @DisplayName("단독 우승자를 가져옵니다.")
    @Test
    void getOneWinner() {
        // given
        for (int k = 0; k < 1; k++) {
            Car car = racingCarList.getCarList()
                    .get(k);
            if (k == 0)
                car.move(new ForwardStrategy());
        }

        // when
        PlayResult playResult = new PlayResult(racingCarList.getCarList());

        // then
        assertThat(playResult.getWinnerNames()).isEqualTo("Thor");
    }

    @DisplayName("공동 우승자를 가져옵니다.")
    @Test
    void getCoWinner() {
        // given, when
        for (int k = 0; k < 2; k++) {
            Car car = racingCarList.getCarList()
                    .get(k);
            car.move(new ForwardStrategy());
        }

        // when
        PlayResult playResult = new PlayResult(racingCarList.getCarList());

        // then
        assertThat(playResult.getWinnerNames()).isEqualTo("Thor, Hulk");
    }

}
