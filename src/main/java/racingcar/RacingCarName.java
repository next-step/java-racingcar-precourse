package racingcar;

public class RacingCarName {

    private static final int MAX_NAME_LENGTH = 5;

    private final String racingCarName;

    public RacingCarName(String racingCarName) {
        if (!validateRacingCarName(racingCarName)) {
            System.out.println(ErrorMessage.RACING_CAR_NAME_LENGTH_ERROR);
            throw new IllegalArgumentException(ErrorMessage.RACING_CAR_NAME_LENGTH_ERROR);
        }
        this.racingCarName = racingCarName;
    }

    private static boolean validateRacingCarName(String racingCarName) {
        return racingCarName.length() < MAX_NAME_LENGTH;
    }

    @Override
    public String toString() {
        return racingCarName;
    }
}
