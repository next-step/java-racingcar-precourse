package racinggame;

import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        GameManager.isValidateInputCarName(Console.readLine());
        GameManager.isValidateInputTryCount(Console.readLine());
        GameManager.running();
        GameManager.gameOver();
    }
}
