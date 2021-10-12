package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.utils.Message;

class RacingCarTest {
    @DisplayName("전달 받은 이름으로 자동차 이름을 가져올 수 있는지 테스트")
    @Test
    void getName_success() {
        assertThat(new RacingCar(new CarName("test")).getCarName()).isEqualTo(new CarName("test"));
    }

    @DisplayName("자동차 이름 5글자 이하일 때 성공 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void constructCar_successWhenNameLengthIs5OrLess(String name) {
        new RacingCar(new CarName(name));
    }

    @DisplayName("자동차 동작상태에 따라 전진 또는 멈추는지 테스트")
    @Test
    void moveForwardOrStop_success() {
        RacingCar racingCar = new RacingCar(new CarName("test"));
        racingCar.moveForwardOrStop(MoveStatus.STOP);
        assertThat(racingCar.getStep()).isEqualTo(new Step(0));
        racingCar.moveForwardOrStop(MoveStatus.FORWARD);
        assertThat(racingCar.getStep()).isEqualTo(new Step(1));
    }

    @DisplayName("자동차 레이싱 상태 메시지 제대로 생성하는지 테스트")
    @Test
    void makeStatusMessage_success() {
        RacingCar racingCar = new RacingCar(new CarName("name"));
        assertThat(racingCar.makeStatusMessage()).isEqualTo(new Message("name : "));

        racingCar.moveForwardOrStop(MoveStatus.FORWARD);
        assertThat(racingCar.makeStatusMessage()).isEqualTo(new Message("name : -"));
    }
}
