package racinggame;

import nextstep.utils.Console;

public class GameSystem {
    Cars cars;

    public void gamePlay() {
        Display.enterName();
        enterCarNames();




    }

    private void enterCarNames() {
        cars = new Cars();
        cars.enterName(Console.readLine());
    }
}
