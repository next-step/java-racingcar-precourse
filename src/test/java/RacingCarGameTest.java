import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import resulttypes.PlayResult;

public class RacingCarGameTest {
    private RacingCarGame racingCarGame;
    private RacingCarColosseum racingCarColosseum;
    private UserInputParser userInputParser;

    @BeforeEach
    void setup()
    {
        this.racingCarColosseum = new RacingCarColosseum(new RandomGenerator());
        this.userInputParser = new UserInputParser();
        this.racingCarGame = new RacingCarGame(this.racingCarColosseum, this.userInputParser);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:5", "pobi, crong, honux:10", "pobi, crong   , honux:7", "korsa, 12345, !@$, a, b, c:20"},
            delimiter = ':')
    @DisplayName("사용자가 정상적인 값을 입력했을 경우 게임을 진행한다.")
    void play_when_input_is_valid(String carNamesInput, String trialCountInput) {
        Assertions.assertThat(this.racingCarGame.play(carNamesInput, trialCountInput)).isEqualTo(PlayResult.PLAYED);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobipobi, crongcrong, honuxhonux:5", "pobi,crong,honux:!@", "korsa, 213, :3a"}, delimiter = ':')
    @DisplayName("사용자가 비정상적인 값을 입력했을 경우 게임을 진행하지 않는다.")
    void not_play_when_input_is_invalid(String carNamesInput, String trialCountInput){
        Assertions.assertThat(this.racingCarGame.play(carNamesInput, trialCountInput)).isEqualTo(PlayResult.INVALID_INPUT);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:5", "pobi, crong, honux:10", "pobi, crong   , honux:7", "korsa, 12345, !@$, a, b, c:20"},
            delimiter = ':')
    void user_input_car_name_is_not_valid(String carNamesInput, String trialCountInput){
        UserInputParser userInputParserMock = mock(UserInputParser.class);
        RacingCarGame racingCarGameWithMock = new RacingCarGame(this.racingCarColosseum, userInputParserMock);

        when(userInputParserMock.parseCarNames(any())).thenReturn(Optional.ofNullable(null));

        Assertions.assertThat(racingCarGameWithMock.play(carNamesInput, trialCountInput)).isEqualTo(PlayResult.INVALID_INPUT);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:5", "pobi, crong, honux:10", "pobi, crong   , honux:7", "korsa, 12345, !@$, a, b, c:20"},
            delimiter = ':')
    void user_input_trial_count_is_not_valid(String carNamesInput, String trialCountInput){
        UserInputParser userInputParserMock = mock(UserInputParser.class);
        RacingCarGame racingCarGameWithMock = new RacingCarGame(this.racingCarColosseum, userInputParserMock);

        when(userInputParserMock.parseTrialCount(any())).thenReturn(Optional.ofNullable(null));

        Assertions.assertThat(racingCarGameWithMock.play(carNamesInput, trialCountInput)).isEqualTo(PlayResult.INVALID_INPUT);
    }
}
