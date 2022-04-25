package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.domain.CarNameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    @DisplayName("자동차 이름 생성")
    void createCarName(){
        String carName = "Tesla";
        assertThat(new CarName(carName).getName()).isEqualTo("Tesla");
    }

    @Test
    @DisplayName("5자 이상 이름 입력 시 예외 발생")
    void exceptionCarNameOverFive(){
        String carName = "TeslaZZang";
        assertThatThrownBy(() ->{
         new CarName(carName);
        }).isInstanceOf(CarNameException.class)
                .hasMessage("[ERROR] 이름은 1자 이상 5자 미만이여야 합니다.");
    }

    @Test
    @DisplayName("이름 미 입력 시 예외 발생")
    void exceptionCarNameUnderZero(){
        String carName = "";
        assertThatThrownBy(() ->{
            new CarName(carName);
        }).isInstanceOf(CarNameException.class)
                .hasMessageContaining("[ERROR] 이름은 1자 이상 5자 미만");
    }

}