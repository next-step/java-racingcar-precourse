package racinggame;

import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        String input = "";
        do {
            input = Console.readLine();
        } while (GameManager.isValidateInputCarName(input));
        do {
            input = Console.readLine();
        } while (GameManager.isValidateInputTryCount(input));
        GameManager.start();
    }
}
