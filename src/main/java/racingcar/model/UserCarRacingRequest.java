package racingcar.model;

import racingcar.common.Constants;

public class UserCarRacingRequest {
    private final String input;

    private UserCarRacingRequest(String input) throws IllegalArgumentException {
        validateInput(input);
        this.input = input;
    }

    /**
     * UserCarRacingRequest creation method
     *
     * @param input user's input
     * @return new UserCarRacingRequest
     */
    public static UserCarRacingRequest valueOf(String input) {
        return new UserCarRacingRequest(input);
    }

    /**
     * Returns an array of car names.
     *
     * @return an array of car names.
     */
    public String[] getCarNameArray() {
        return input.split(",");
    }

    /**
     * the input verification logic used in the creation process. Throws an exception if input is an empty string.
     *
     * @param input input
     */
    private void validateInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(Constants.COMMON_ERROR_HEADER.concat("다시 입력해주세요."));
        }
    }
}
