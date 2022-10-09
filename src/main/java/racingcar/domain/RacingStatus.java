package racingcar.domain;

public enum RacingStatus {

    STOP(""),
    MOVING_FORWARD("-");

    private final String racingStatusValue;

    RacingStatus(String racingStatusValue) {
        this.racingStatusValue = racingStatusValue;
    }

    public boolean isForward() {
        return this == MOVING_FORWARD;
    }

    public static String printRacingStatus(RacingCarLocation racingCarLocation) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int cnt = 0; cnt < racingCarLocation.getLocation(); cnt++) {
            stringBuilder.append(MOVING_FORWARD.racingStatusValue);
        }
        return stringBuilder.toString();
    }

    public static RacingStatus checkStatus(RacingNumber racingNumber) {
        if(racingNumber.isForward()) {
            return RacingStatus.MOVING_FORWARD;
        }
        return RacingStatus.STOP;
    }

    public static String getRacingStatusValue(RacingStatus racingStatus) {
        return racingStatus.racingStatusValue;
    }

}
