package racingcar.application.port.in;

import racingcar.domain.TotalRaceRound;
import racingcar.util.RaceRoundInputCheck;
import racingcar.util.SelfValidating;

public class PlayRacingCommand extends SelfValidating<PlayRacingCommand> {
    @RaceRoundInputCheck
    private final String userInput;

    public PlayRacingCommand(String userInput) {
        this.userInput = userInput;
        super.validateSelf();
    }

    public TotalRaceRound getTotalRaceRound() {
        return new TotalRaceRound(Integer.parseInt(userInput));
    }
}
