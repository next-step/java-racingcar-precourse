package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Drivers;
import racingcar.domain.Match;

public class MatchTest {
    @Test
    void 승자(){
        String[] userInput = {"aaaa","bbbb","cccc","dddd"};
        Drivers drivers = new Drivers(userInput);

        Match match = new Match(drivers);
        match.paly();

        Assertions.assertThat(match.result()).isEqualTo("aaaa,cccc");
    }
}
