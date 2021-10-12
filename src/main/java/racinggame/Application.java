package racinggame;

import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        CarView carView = new CarView();
        carView.startGame();
        Console.readLine();



    }
}
