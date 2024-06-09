import java.util.Scanner;

import Controller.*;
import Model.*;
import View.*;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
            RacingGameView view = new RacingGameView();
            String[] input = view.inputCarName(); // 입력 받기
            int repeat = view.inputRepeatCount(); // 입력 받기
            RacingGame game = new RacingGame(input, repeat);
            game.startGame();
            game.endGame();
    }
}
