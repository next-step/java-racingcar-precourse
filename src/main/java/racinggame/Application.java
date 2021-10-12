package racinggame;

import racinggame.view.RacingCarView;

public class Application {
    public static void main(String[] args) {
        RacingCarView racingCarView = new RacingCarView();
        while (true) {
            try {
                racingCarView.play();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
    }
}
