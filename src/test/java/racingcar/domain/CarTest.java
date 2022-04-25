package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.OutputView;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("5자 이하의 자동차 이름 만들기")
    void MAKE_CAR_NAME_UNDER_5DIGIT(){
        Car car = new Car("ara");
        assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("5자 이상의 자동차 이름 생성 실패하기")
    void MAKE_CAR_NAME_OVER_5DIGIT(){
        assertThatIllegalArgumentException().isThrownBy(()-> new Car("iceChoco"));
    }

    @Test
    @DisplayName("공백으로 된 자동차 이름 생성 실패하기")
    void MAKE_CAR_NAME_ONLY_EMPTY(){
        assertThatIllegalArgumentException().isThrownBy(()-> new Car("     "));
    }

    @Test
    @DisplayName("자동차 전진하기")
    void MOVING_CAR_FORWARD(){
        Car car = new Car("ara");
        car.callGoOrStop(4);
        assertThat(car.getPosition().toString()).isEqualTo("1");
    }

    @Test
    @DisplayName("자동차 정지하기")
    void STOP_CAR(){
        Car car = new Car("ara");
        car.callGoOrStop(3);
        assertThat(car.getPosition().toString()).isEqualTo("0");
    }
}
