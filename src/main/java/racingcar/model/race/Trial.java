package racingcar.model.race;

import racingcar.model.value.ErrorMsg;
import racingcar.model.value.Rule;

public class Trial {

    private static final String TRIAL_PATTERN = "^[1-9][0-9]*$";

    private int trial;

    public Trial(final String trialInput) {
        trial = Rule.DEFAULT_TRIAL;
        validateTrialInput(trialInput);
        trial = Integer.parseInt(trialInput);
    }

    private void validateTrialInput(final String trialInput) {
        if (!trialInput.matches(TRIAL_PATTERN)) {
            throw new IllegalArgumentException(ErrorMsg.WRONG_TYPE);
        }
    }

    public boolean biggerThan(int i) {
        return trial > i;
    }
}
