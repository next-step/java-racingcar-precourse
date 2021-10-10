package racinggame;

import custom.utils.ValidationUtils;
import service.RacingSevice;

public class Application {
    public static void main(String[] args) {

        System.out.println("[SYSTEM MESSAGE] RACING GAME START");
        RacingSevice racingSevice = new RacingSevice();
        racingSevice.startRacingGame();

    }
}
