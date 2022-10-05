package racingcar.model;

import static racingcar.common.Constants.*;

public class UserTrialRequest {
    private final String input;

    private UserTrialRequest(String input) throws IllegalArgumentException {
        validateInput(input);
        this.input = input;
    }

    /**
     * UserTrialRequest creation method
     *
     * @param input user's input
     * @return new UserTrialRequest
     */
    public static UserTrialRequest valueOf(String input) {
        return new UserTrialRequest(input);
    }

    public int getTrial() {
        return Integer.parseInt(input);
    }

    /**
     * the input verification logic used in the creation process. Throws an exception if there is a problem with the
     * input.
     *
     * @param input input
     */
    private void validateInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(getInputErrorMessage());
        }
    }

    /**
     * Returns InputErrorMessage
     *
     * @return InputErrorMessage
     */
    private String getInputErrorMessage() {
        return COMMON_ERROR_HEADER.concat(ERROR_TRIAL_INPUT);
    }
}
