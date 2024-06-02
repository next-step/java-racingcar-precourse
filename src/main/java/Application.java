import Controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.getCarNames();
        gameController.getRounds();
        gameController.gamePlay();
        gameController.gameResult();

    }
}
