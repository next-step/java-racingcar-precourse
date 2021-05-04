import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UserInputParserTest {
    private UserInputParser userInputParser;

    @BeforeEach
    void setup() {
        this.userInputParser = new UserInputParser();
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux", "pobi,alex,sand,krosa", "i,am,groot", "ionic,tesla,ford,audi"})
    @DisplayName("사용자가 정상적인 자동차 이름을 입력한 경우 PlayerNameContainer가 담긴 Optional 객체를 반환한다.")
    void parse_valid_player_names_input(String playerNamesInput) {
        Optional<PlayerNameContainer> mayPlayerNameContainer = this.userInputParser.parsePlayerNames(playerNamesInput);

        Assertions.assertThat(mayPlayerNameContainer.isPresent()).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"wrterddf,2314cx", "12308d,192887ds,!@8c8*cc", "&*(sd1", "czvzxdeterd,!))*Fdf"})
    @DisplayName("사용자가 비정상적인 자동차 이름을 입력한 경우 null이 담긴 Optional 객체를 반환한다.")
    void parse_invalid_player_names_input(String playerNamesInput) {
        Optional<PlayerNameContainer> mayPlayerNameContainer = this.userInputParser.parsePlayerNames(playerNamesInput);

        Assertions.assertThat(mayPlayerNameContainer.isPresent()).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"124", "2", "4", "11", "2", "453", "333", "72", "13", "88956", "409", "34"})
    @DisplayName("사용자가 정상적인 시도 횟수를 입력한 경우 TrialCount가 담긴 Optional 객체를 반환한다.")
    void parse_valid_trial_count_input(String trialCntInput) {
        Optional<TrialCount> mayTrialCount = this.userInputParser.parseTrialCount(trialCntInput);

        Assertions.assertThat(mayTrialCount.isPresent()).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"124cx", "!2", "4dz", "a", "_", "vc", "(*6", "^", "&", "aaabb", "_2", "34_"})
    @DisplayName("사용자가 비정상적인 시도 횟수를 입력한 경우 null이 담긴 Optional 객체를 반환한다.")
    void parse_invalid_trial_count_input(String trialCntInput) {
        Optional<TrialCount> mayTrialCount = this.userInputParser.parseTrialCount(trialCntInput);

        Assertions.assertThat(mayTrialCount.isPresent()).isFalse();
    }
}
