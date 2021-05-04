import resulttypes.PlayResult;

import java.util.Optional;

public class RacingCarGame {
    private static final String WINNER_MSG_TAIL = "가 최종 우승했습니다.";
    private RacingCarColosseum racingCarColosseum;
    private UserInputParser userInputParser;

    public RacingCarGame(RacingCarColosseum racingCarColosseum, UserInputParser userInputParser) {
        this.racingCarColosseum = racingCarColosseum;
        this.userInputParser = userInputParser;
    }

    public PlayResult play(String playerNamesInput, String trialCountInput) {
        Optional<PlayerNameContainer> mayPlayerNames = this.userInputParser.parsePlayerNames(playerNamesInput);
        Optional<TrialCount> mayTrialCount = this.userInputParser.parseTrialCount(trialCountInput);

        if (!mayPlayerNames.isPresent() || !mayTrialCount.isPresent()) {
            return PlayResult.INVALID_INPUT;
        }

        this.playInColosseum(mayPlayerNames.get(), mayTrialCount.get());

        return PlayResult.PLAYED;
    }

    private void playInColosseum(PlayerNameContainer playerNames, TrialCount trialCount) {
        CarPlayerContainer winners = this.racingCarColosseum.play(playerNames, trialCount);

        System.out.println(winners.toString() + WINNER_MSG_TAIL);
    }
}
