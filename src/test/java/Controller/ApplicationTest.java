package Controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import Util.CheckNameValidity;
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

    @Test
    @DisplayName("올바른 이름의 입력이 이루어지는지 테스트")
    void 자동차이름입력테스트()throws IOException{
        // 올바른 입력
        String correctName = "pobi";
        assertThat(CheckNameValidity.checkNameValidity(correctName)).isEqualTo(true);
        // 공백 포함
        String incorrectNameBlank = "po bi";
        assertThat(CheckNameValidity.checkNameValidity(incorrectNameBlank)).isEqualTo(false);
        // 영어로 이루어져있지 않음
        String incorrectNameNotEnglish = "4비";
        assertThat(CheckNameValidity.checkNameValidity(incorrectNameNotEnglish)).isEqualTo(false);
        // 이름 중복
        String incorrectSameName = "same,same";
        Game game = new Game();
        game.separateName(incorrectSameName);
        assertThat(game.makeCars()).isEqualTo(false);
        // 자동차 1대 일때
        String incorrectNameJustOneCar = "pobi";
        game = new Game();
        game.separateName(incorrectSameName);
        assertThat(game.makeCars()).isEqualTo(false);
    }
}