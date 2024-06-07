package race.handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.model.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputHandlerTest {
    static final InputHandler inputHandler = InputHandler.getInstance();

    @Test
    @DisplayName("입력값에서 comma 옆의 space가 제거되는 지 테스트")
    void test_exceedNameLength() {
        // given
        String stringWithComma = "aaa  ,  bbb  ,  ccc";

        // when
        List<Car> carList = inputHandler.inputForCarNameList(stringWithComma);

        // then
        List<String> carNameList = carList.stream()
                .map(Car::getCarName)
                .toList();

        assertThat(carNameList).containsExactly("aaa", "bbb", "ccc");
    }
}