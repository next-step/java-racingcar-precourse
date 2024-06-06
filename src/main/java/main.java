public class main {
    public static void main(String[] args) {
        // get input(Car names & tryCount) from gameController
        GameController gameController = new GameController();
        String[] carNames = gameController.inputCarNames();
        int tryCount = gameController.inputTryCount();

        // game service(manager)
        GameService gameService = new GameService(tryCount, carNames);
        gameService.gameStart();

    }
}
