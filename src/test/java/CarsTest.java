import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    Car car;
    CheckInput checkInput;
    Game game;

    @BeforeEach
    void setUp() {
        checkInput=new CheckInput();
        game= new Game();
    }

    @ParameterizedTest
    @ValueSource(strings = "aaa,bbb,abdcdddd")
    @DisplayName("입력받은 자동차 이름 길이 유효성 검사,길이가 5이상 일 경우(예외 발생)")
    void checkInputCarNameLengthValidException(final String name) {
        assertThatThrownBy(() -> game.getCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 차 이름의 길이는 1글자~5글자 사이로 입력해주세요.");
    }
}
