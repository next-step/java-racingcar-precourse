public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.gameSetting();
        gameController.gamePlay();
        gameController.gameDone();
    }
}
