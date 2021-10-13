package racinggame;

import racinggame.ui.OutputView;
import racinggame.ui.RacingGameDriver;

public class Application {

    public static void main(String[] args) {
        try {
            final RacingGameDriver driver = new RacingGameDriver();
            driver.play();
        } catch (IllegalArgumentException ex) {
            OutputView.print(ex.getMessage());
        }
    }
}
