package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarNames;

public class CarNamesTest {
    @Test
    @DisplayName("입력받은 문자열로 차량을 만든다.")
    void 차량_생성() {
        //given
        String inputString = "Test1, Test2, Test 3";

        //when
        CarNames carNames = new CarNames(inputString);

        //then
        assertThat(carNames.getCount()).isEqualTo(3);
        assertThat(carNames.getCarName(1)).isEqualTo("Test2");
        assertThat(carNames.getCarName(2)).isEqualTo("Test 3");
    }

}
