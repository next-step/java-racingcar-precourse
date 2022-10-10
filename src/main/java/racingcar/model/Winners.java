package racingcar.model;

public class Winners {
    PlayerGroup playerGroup;
    Distance distance;

    public static final String WINNER_SEPARATOR = ", ";
    public static final String WINNER_NOTICE_STR = "최종 우승자 : ";

    public Winners(PlayerGroup group) {
        playerGroup = new PlayerGroup();
        distance = new Distance();

        for (Player player : group.getPlayerGroup()) {
            setWinnerGroup(player);
        }
    }

    private void setWinnerGroup(Player player) {
        int compared = player.getCar().getDistance().compareTo(distance);
        int equal = 0;

        if (compared > equal) {
            playerGroup.reset();
        }

        if (compared >= equal) {
            playerGroup.append(player);
            this.distance = player.getCar().getDistance();
        }
    }

    public String toStringFinalWinnerNames() {
        StringBuilder sb = new StringBuilder();

        for (Player player : playerGroup.getPlayerGroup()) {
            sb.append(player.getCar().getCarName().getCarNameValue());
            sb.append(WINNER_SEPARATOR);
        }
        return WINNER_NOTICE_STR + sb.substring(0, sb.length() -2);
    }
}
