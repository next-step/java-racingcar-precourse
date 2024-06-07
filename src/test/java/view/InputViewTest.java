package view;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    @Test
    @DisplayName("입력된 문자열의 길이가 5가 넘을 때 차량 이름 입력 테스트")
    public void testInputCarNameWhenTheInputIsTooLong() {
        // given
        String input = "car123456\ncar1,car2,car3\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // when
        List<String> carNames = InputView.inputCarName();

        // then
        String expectedOutput = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n[ERROR] 자동차의 이름은 5자를 초과할 수 없습니다.\n경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
        assertThat(outputStream.toString()).isEqualTo(expectedOutput);
        assertThat(carNames).isEqualTo(Arrays.asList("car1", "car2", "car3"));
    }
}