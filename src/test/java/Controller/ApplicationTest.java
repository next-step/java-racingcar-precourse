package Controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest {
    @Test
    @DisplayName("이름이 , 로 구분이 잘되는지 테스트")
    void 문자열분리테스트()throws IOException {
        Game game = new Game();
        String name = "A,B,C,D";
        game.separateName(name);
        assertThat(game.getBeforeCheckCarNames()[0]).isEqualTo("A");
        assertThat(game.getBeforeCheckCarNames()[1]).isEqualTo("B");
        assertThat(game.getBeforeCheckCarNames()[2]).isEqualTo("C");
        assertThat(game.getBeforeCheckCarNames()[3]).isEqualTo("D");
    }
}