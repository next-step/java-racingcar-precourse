package racingcar.model;

public class WinnerGroup {
    RacerGroup winnerGroup;
    Distance distance;

    public static final String WINNER_SEPARATOR = ", ";
    public static final String WINNER_NOTICE_STR = "최종 우승자: ";

    public WinnerGroup(RacerGroup group) {
        winnerGroup = new RacerGroup();
        distance = new Distance();

        for (Racer racer : group.getRacerGroup()) {
            setWinnerGroup(racer);
        }
    }

    private void setWinnerGroup(Racer racer) {
        int compared = racer.getCar().getDistance().compareTo(distance);
        int equal = 0;

        if (compared > equal) {
            winnerGroup.reset();
        }

        if (compared >= equal) {
            winnerGroup.append(racer);
            this.distance = racer.getCar().getDistance();
        }
    }

    public String toStringFinalWinnerNames() {
        StringBuilder winners = new StringBuilder();

        for (Racer racer : winnerGroup.getRacerGroup()) {
            winners.append(racer.getCar().getCarName());
            winners.append(WINNER_SEPARATOR);
        }

        return WINNER_NOTICE_STR + winners.substring(0, winners.length() -2);
    }
}
