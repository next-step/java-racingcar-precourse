package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RaceTest {

    @DisplayName("경주 횟수에 따라 1번 진행했을때 isFinished 결과값이 달라진다.")
    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, false"})
    void isFinished_normal(int iterationCount, boolean expected) {
        //given
        Race race = Race.of(new String[]{"user"}, iterationCount);
        race.iterate();
        //when
        boolean actual = race.isFinished();
        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
