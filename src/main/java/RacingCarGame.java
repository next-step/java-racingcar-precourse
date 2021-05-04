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
        Optional<PlayerNameContainer> mayPlayerNameContainer = this.userInputParser.parsePlayerNames(playerNamesInput);
        Optional<TrialCount> mayTrialCount = this.userInputParser.parseTrialCount(trialCountInput);

        if (!mayPlayerNameContainer.isPresent() || !mayTrialCount.isPresent()) {
            return PlayResult.INVALID_INPUT;
        }

        this.playInColosseum(mayPlayerNameContainer.get(), mayTrialCount.get());

        return PlayResult.PLAYED;
    }

    private void playInColosseum(PlayerNameContainer playerNameContainer, TrialCount trialCount) {
        CarPlayerContainer winners = this.racingCarColosseum.play(playerNameContainer, trialCount);

        System.out.println(winners.toString() + WINNER_MSG_TAIL);
    }
}
