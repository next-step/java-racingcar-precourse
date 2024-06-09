package camp.nextstep.edu;

import camp.nextstep.edu.controller.RacingGame;
import camp.nextstep.edu.view.Input;
import camp.nextstep.edu.view.Output;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Input input = new Input(new Scanner(System.in));
        Output output = new Output();

        RacingGame racingGame = new RacingGame(input, output);
        racingGame.run();
    }
}
