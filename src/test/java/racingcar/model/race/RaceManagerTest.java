package racingcar.model.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.value.ErrorMsg;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RaceManagerTest {

    @ParameterizedTest
    @ValueSource(strings = {"테 슬 라", "마 이바흐",})
    @DisplayName(value = "자동차이름 whitespace 예외발생")
    void 차이름_공백_입력_예외발생_테스트(String carName) {
        assertThatThrownBy(() -> {
            RaceManager raceManager = new RaceManager();
            raceManager.addCars(carName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMsg.WHITE_SPACE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"페라리", "마이바흐", "테슬라", "람보르기니"})
    @DisplayName(value = "이름 1개로 자동차이름 생성")
    void 자동차_한대만_입력_예외발생_테스트(String carName) {
        assertThatThrownBy(() -> {
            RaceManager raceManager = new RaceManager();
            raceManager.addCars(carName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMsg.ONE_CAR_NAME);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ferrari,마이바흐533", "테슬라,람보르기니윙도어"})
    @DisplayName(value = "자동차이름길이 초과")
    void 자동차_이름길이_초과_예외발생_테스트(String carName) {
        assertThatThrownBy(() -> {
            RaceManager raceManager = new RaceManager();
            raceManager.addCars(carName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMsg.CAR_NAME_LENGTH_NO_MATCH);
    }

    @ParameterizedTest
    @ValueSource(strings = {"테슬라,테슬라", "테슬라,람보르기니,벤츠,람보르기니"})
    @DisplayName(value = "자동차이름 중복입력")
    void 자동차_이름_중복입력_예외발생_테스트(String carName) {
        assertThatThrownBy(() -> {
            RaceManager raceManager = new RaceManager();
            raceManager.addCars(carName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMsg.DUPLICATE_NAME);
    }

    @ParameterizedTest
    @ValueSource(strings = {",마이바흐", ",테슬라"})
    @DisplayName(value = "자동차이름 비었을때")
    void 자동차_이름_없을때_테스트(String carName) {
        assertThatThrownBy(() -> {
            RaceManager raceManager = new RaceManager();
            raceManager.addCars(carName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMsg.CAR_NAME_LENGTH_NO_MATCH);
    }

    @ParameterizedTest
    @ValueSource(strings = {"마이바흐,", "테슬라,"})
    @DisplayName(value = "맨 끝에 쉼표는 없는 취급한다.")
    void 맨끝_쉼표_무시_테스트(String carName) {
        assertThatThrownBy(() -> {
            RaceManager raceManager = new RaceManager();
            raceManager.addCars(carName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMsg.ONE_CAR_NAME);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aa", "1a3", "3.3", "-12"})
    @DisplayName(value = "시도횟수 타입 예외발생 테스트")
    void 시도횟수_타입_예외발생_테스트(String trial) {
        assertThatThrownBy(() -> {
            RaceManager raceManager = new RaceManager();
            raceManager.addTrial(trial);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMsg.WRONG_TYPE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0"})
    @DisplayName(value = "시도횟수 0 예외발생테스트")
    void 시도횟수_0회이하_예외발생_테스트(String trial) {
        assertThatThrownBy(() -> {
            RaceManager raceManager = new RaceManager();
            raceManager.addTrial(trial);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMsg.WRONG_TYPE);
    }
}
