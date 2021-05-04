import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingCarColosseumTest {
    private RacingCarColosseum racingCarColosseum;
    private RandomGenerator randomGenerator;

    @BeforeEach
    void setup() {
        this.randomGenerator = mock(RandomGenerator.class);
        this.racingCarColosseum = new RacingCarColosseum(this.randomGenerator);
    }

    @ParameterizedTest
    @CsvSource(value = {"zcv,wer,qwer:5", "pobi,crong,honux,korsa:10"}, delimiter = ':')
    @DisplayName("게임이 진행되고 나면 적어도 한 명 이상의 우승자가 나와야 한다.")
    void play_on_normal_case(String playerNamesInput, String trialCountInput) {
        PlayerNameContainer playerNameContainer = new PlayerNameContainer(playerNamesInput.split(","));
        TrialCount trialCount = new TrialCount(trialCountInput);

        CarPlayerContainer winners = this.racingCarColosseum.play(playerNameContainer, trialCount);

        Assertions.assertThat(winners.size()).isGreaterThan(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"zcv,wer,qwer:5", "pobi,crong,honux,korsa:10"}, delimiter = ':')
    @DisplayName("게임이 진행되고 모든 랜덤 값이 전진 조건을 만족하지 못하면 전원 우승자가 된다.")
    void play_when_every_random_value_not_satisfy_trial_condition(String playerNamesInput, String trialCountInput) {
        PlayerNameContainer playerNameContainer = new PlayerNameContainer(playerNamesInput.split(","));
        TrialCount trialCount = new TrialCount(trialCountInput);
        when(this.randomGenerator.get()).thenReturn(Car.STAY_MAX_RANDOM_VALUE);

        CarPlayerContainer winners = this.racingCarColosseum.play(playerNameContainer, trialCount);

        Assertions.assertThat(winners.size()).isEqualTo(playerNameContainer.size());
    }

    @ParameterizedTest
    @CsvSource(value = {"zcv,wer,qwer:5", "pobi,crong,honux,korsa:10"}, delimiter = ':')
    @DisplayName("게임이 진행되고 모든 랜덤 값이 전진 조건을 만족하면 전원 우승자가 된다.")
    void play_when_every_random_value_satisfy_trial_condition(String playerNamesInput, String trialCountInput) {
        PlayerNameContainer playerNameContainer = new PlayerNameContainer(playerNamesInput.split(","));
        TrialCount trialCount = new TrialCount(trialCountInput);
        when(this.randomGenerator.get()).thenReturn(Car.MOVE_MIN_RANDOM_VALUE);

        CarPlayerContainer winners = this.racingCarColosseum.play(playerNameContainer, trialCount);

        Assertions.assertThat(winners.size()).isEqualTo(playerNameContainer.size());
    }
}
