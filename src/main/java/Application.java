import controller.GameController;

public class Application {

    private final static GameController gameController = new GameController();

    public static void main(String[] args) {
        gameController.run();
    }
}
