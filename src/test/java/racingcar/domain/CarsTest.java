package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.common.Message;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    Cars cars;

    @BeforeEach
    void init() {
        String carNames = "pobi,toyo,asora";
        cars = new Cars(carNames);
    }

    @ParameterizedTest
    @DisplayName("자동차_입력_갯수_체크")
    @ValueSource(strings = { "pobi", "crong", "pobi," })
    void 자동차_이름_입력_갯수_체크(String carNames) {
        assertThatThrownBy(() -> {
            new Cars(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_MIN_CAR_COUNT);
    }

    @ParameterizedTest
    @DisplayName("자동차_중복_체크")
    @ValueSource(strings = { "pobi,crong,pobi,honux", "joseh,suara,doyo,suara" })
    void 자동차_이름_중복_체크(String carNames) {
        assertThatThrownBy(() -> {
            new Cars(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_CAR_NOT_UNIQUE);
    }

    @ParameterizedTest
    @DisplayName("우승자_리스트에_자동차_포함_O_체크")
    @ValueSource(ints = { 3 })
    void 우승자_리스트에_자동차_포함_O_체크(int maxPosition) {
        List<Car> winnerList = new ArrayList<Car>();
        cars.addWinnerCar(winnerList, new Car("toyo", 3), new Position(maxPosition));
        assertThat(winnerList.size() > 0).isTrue();
    }

    @ParameterizedTest
    @DisplayName("우승자_리스트에_자동차_포함_X_체크")
    @ValueSource(ints = { 4, 5, 6 })
    void 우승자_리스트에_자동차_포함_X_체크(int maxPosition) {
        List<Car> winnerList = new ArrayList<Car>();
        cars.addWinnerCar(winnerList, new Car("toyo", 3), new Position(maxPosition));
        assertThat(winnerList.size() > 0).isFalse();
    }

    @Test
    @DisplayName("우승자_인원수_체크")
    void 우승자_인원수_체크() {
        cars.move();
        assertThat(cars.findWinners().size() > 0).isTrue();
    }
}
