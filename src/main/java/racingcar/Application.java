package racingcar;

import racingcar.entities.*;
import racingcar.utils.ConsoleView;
import racingcar.utils.Game;
import racingcar.utils.StringHandler;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        StringHandler stringHandler = new StringHandler();
        ConsoleView consoleView = new ConsoleView();
        NamesInput namesInput = consoleView.getNamesInput();
        GameTimeInput gameTimeInput = consoleView.getGameTimeInput();
        ArrayList<Car> cars = namesInput.constructCars();

        for (int timeOfGame = 1; timeOfGame <= gameTimeInput.getGameTime(); timeOfGame++) {
            Game.playGame(cars);
        }
        String winnersName = stringHandler.insertCommaBetweenWinnersName(game.pickWinnerCars(cars));
        consoleView.announceWinner(winnersName);
    }

}