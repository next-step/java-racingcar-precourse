package racingcar.view;

import java.util.List;

public class WinnerRacingCarViews {
    private static final String delimiter = ",";
    private final List<RaceCarView> views;

    public WinnerRacingCarViews(List<RaceCarView> views) {
        this.views = views;
    }

    public static WinnerRacingCarViews of(List<RaceCarView> views) {
        return new WinnerRacingCarViews(views);
    }

    public String getWinners() {
        String[] winnerNames = new String[views.size()];
        for (int i = 0; i < views.size(); i++) {
            winnerNames[i] = views.get(i).getName();
        }
        return String.join(delimiter, winnerNames);
    }
}
