import domain.RacingGameManager;

public class Application {

    public static void main(String[] args) {
        RacingGameManager manager = new RacingGameManager();

        manager.setup();
        manager.start();


    }
}
