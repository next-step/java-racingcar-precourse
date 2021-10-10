package racinggame;

import racinggame.controller.GameMachine;

public class Application {
    public static void main(String[] args) {
        GameMachine gameMachine = new GameMachine();
        gameMachine.runRaceGame();
    }
}
