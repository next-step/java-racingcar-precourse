import resulttypes.PlayResult;

import java.util.Optional;

public class RacingCarGame {
    public static final String WINNER_MSG_TAIL = "가 최종 우승했습니다.";
    private RacingCarColosseum racingCarColosseum;
    private UserInputParser userInputParser;

    public RacingCarGame(RacingCarColosseum racingCarColosseum, UserInputParser userInputParser) {
        this.racingCarColosseum = racingCarColosseum;
        this.userInputParser = userInputParser;
    }

    public PlayResult play(String carNamesInput, String trialCountInput) {
        Optional<CarNameContainer> mayCarNameContainer = this.userInputParser.parseCarNames(carNamesInput);
        Optional<TrialCount> mayTrialCount = this.userInputParser.parseTrialCount(trialCountInput);

        if (!mayCarNameContainer.isPresent() || !mayTrialCount.isPresent()) {
            return PlayResult.INVALID_INPUT;
        }

        this.playInColosseum(mayCarNameContainer.get(), mayTrialCount.get());

        return PlayResult.PLAYED;
    }

    private void playInColosseum(CarNameContainer carNameContainer, TrialCount trialCount) {
        CarPlayerContainer winners = this.racingCarColosseum.play(carNameContainer, trialCount);

        System.out.println(winners.toString() + WINNER_MSG_TAIL);
    }
}
