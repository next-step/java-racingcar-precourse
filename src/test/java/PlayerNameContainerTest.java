import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayerNameContainerTest {
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:3", "ssem,korsa,!@566:3", "acx1$:1", "a,bbb:2"}, delimiter = ':')
    @DisplayName("사용자가 정상적인 자동차 이름을 입력했을 경우 입력값을 보관한다.")
    void store_in_container_when_user_input_is_valid(String playerNamesInput, int playerNameCount) {
        Assertions.assertThat(new PlayerNameContainer(playerNamesInput.split(",")).size()).isEqualTo(playerNameCount);
        Assertions.assertThatNoException()
                .isThrownBy(() -> new PlayerNameContainer(playerNamesInput.split(",")));
    }

    @ParameterizedTest
    @CsvSource(value = {"zxcvewdsfsdaf", "123456", "dsf4567", "%$^&*(!"})
    @DisplayName("사용자가 비정상적인 자동차 이름을 입력했을 경우 IllegalArgumentException 예외를 던진다.")
    void not_store_in_container_when_user_input_is_valid(String playerNamesInput) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerNameContainer(playerNamesInput.split(",")));
    }
}
