package racingcar;

public class Application {
    public static void main(String[] args) {
        Circuit circuit = new Circuit();
        GameView view = new GameView();
        GameController controller = new GameController(circuit, view);
        GameBoard board = new GameBoard(controller);

        board.run();
    }
}
