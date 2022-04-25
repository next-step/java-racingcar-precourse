package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceActionGeneratorTest {
    @Test
    void testNextAction() {
        FakeRandomNumberGenerator fakeRandomNumberGenerator = new FakeRandomNumberGenerator(new int[]{0, 3, 4, 9});
        RaceActionGenerator raceActionGenerator = new RaceActionGenerator(fakeRandomNumberGenerator);
        assertThat(raceActionGenerator.nextAction()).isEqualTo(RaceAction.STOP);
        assertThat(raceActionGenerator.nextAction()).isEqualTo(RaceAction.STOP);
        assertThat(raceActionGenerator.nextAction()).isEqualTo(RaceAction.TRAVEL);
        assertThat(raceActionGenerator.nextAction()).isEqualTo(RaceAction.TRAVEL);
    }
}
