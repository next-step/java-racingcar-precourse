import resulttypes.PlayResult;

import java.util.List;
import java.util.Optional;

public class RacingCarGame {
    public static final String WINNER_MSG_TAIL = "가 최종 우승했습니다.";
    private RacingCarColosseum racingCarColosseum;
    private UserInputParser userInputParser;

    public RacingCarGame() {
        this.racingCarColosseum = new RacingCarColosseum(new RandomGenerator());
        this.userInputParser = new UserInputParser();
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
        List<CarPlayer> winners = this.racingCarColosseum.play(carNameContainer, trialCount);

        String winnerMsg = this.getWinnerMessage(winners);

        System.out.println(winnerMsg);
    }

    private String getWinnerMessage(List<CarPlayer> winners) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i).getCarName());
            if (i != winners.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(WINNER_MSG_TAIL);

        return sb.toString();
    }
}
