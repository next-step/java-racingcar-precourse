package racinggame.sevice;

import racinggame.model.CarSet;
import racinggame.util.GameInput;

import java.util.ArrayList;

public class Game {
    private static final Game GAME = new Game();
    private GameInput gameInput;
    private CarSet carSet;

    private Game(){
        gameInput = GameInput.getGameInputInstance();
        carSet = CarSet.getCarSetInstance();
    }

    public static Game getGameInstance() {
        return GAME;
    }

    public void play(){
        inputCarName();
        gameRun(inputPlayCount());
        outputResult();
    }

    private void inputCarName() {
        ArrayList<String> input;
        do {
            input = gameInput.getInputCarName();
        } while (!gameInput.checkCarName(input));
    }

    private int inputPlayCount() {
        String input;
        do {
            input = gameInput.getInputPlayCount();
        } while (!gameInput.checkPlayCount(input));

        return Integer.parseInt(input);
    }

    private void gameRun(int count) {
        for (int i = 0; i < count; i++) {
            carSet.moveCars();
            carSet.printOutput();
        }
    }

    private void outputResult() {
        String winners = carSet.getWinner();
    }
}
