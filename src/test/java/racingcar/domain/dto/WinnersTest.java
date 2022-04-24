package racingcar.domain.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Names;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @DisplayName("Names 배열을 가진다.")
    @ParameterizedTest
    @ValueSource(strings = {"miz,ki,bi"})
    void createWinnerTest(String input) {
        Names names = Names.from(input);
        Winners winners = Winners.from(names);

        assertThat(winners.getWinnersString()).isEqualTo(input);
    }

}