import org.junit.jupiter.api.Test;
import view.InputView;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @Test
    public void parseCarNamesShouldSplitNamesByComma() {
        InputView inputView = new InputView();
        List<String> carNames = inputView.parseCarNames("pobi,woni,jun");
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    public void parseTryCountShouldReturnInteger() {
        InputView inputView = new InputView();
        int tryCount = inputView.parseTryCount("5");
        assertThat(tryCount).isEqualTo(5);
    }

    @Test
    public void parseCarNamesShouldThrowExceptionForInvalidNames() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.parseCarNames("pobi,toolong,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    public void parseTryCountShouldThrowExceptionForInvalidNumber() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.parseTryCount("invalid"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효한 숫자를 입력하세요.");
    }

    @Test
    public void parseTryCountShouldThrowExceptionForNonPositiveNumber() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.parseTryCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
    }
}
