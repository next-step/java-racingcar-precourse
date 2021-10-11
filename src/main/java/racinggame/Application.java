package racinggame;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameConsole gameConsole = new GameConsole();
        List<String> carNames = gameConsole.getInputValue();
        carNames.forEach(System.out::println);
    }
}
