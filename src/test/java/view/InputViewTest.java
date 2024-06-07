package view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @Test
    @DisplayName("입력된 문자열의 길이가 5가 넘을 때 차량 이름 입력 테스트")
    public void testInputCarNameWhenTheInputIsTooLong() throws Exception {
        // given
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String input = "car123456\n" + "car1,car2,car3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        List<String> carNames = InputView.inputCarName();

        // then
        assertThat(outContent.toString()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n[ERROR] 자동차의 이름은 5자를 초과할 수 없습니다.\n경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        assertThat(carNames).isEqualTo(Arrays.asList("car1", "car2", "car3"));
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("입력된 문자열이 없을때 이름 입력 테스트")
    public void testInputCarNameWhenTheInputIsEmpty() throws Exception {
        // given
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String input = "\n" + "car1,car2,car3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        List<String> carNames = InputView.inputCarName();

        // then
        assertThat(outContent.toString()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n[ERROR] 공백은 허용 되지 않습니다.\n경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        assertThat(carNames).isEqualTo(Arrays.asList("car1", "car2", "car3"));
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("차량 입력 중에 공백을 strip할 수 있는지 테스트")
    public void testInputCarNameWhenTheInputHasTheSpace() throws Exception {
        // given
        String input = "car4, car5, car6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        List<String> carNames = InputView.inputCarName();

        // then
        assertThat(carNames).isEqualTo(Arrays.asList("car4", "car5", "car6"));
    }

    @Test
    @DisplayName("입력횟수에 숫자가 아닌 다른 문자가 들어올때 테스트")
    public void testInputIterationWithNonNumericalInput() throws Exception {
        // given
        String input = "a\n1\n"; // 첫 번째 입력은 숫자가 아닌 "a", 두 번째 입력은 유효한 숫자 "1"
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        int iteration = InputView.inputGameIteration();

        // then
        assertThat(iteration).isEqualTo(1); // 유효한 숫자 입력 "1"이 반환되어야 함
    }
}