import controller.GameController;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        List<String> displays = gameController.displayCarsMovements();
        for (String display : displays) {
            System.out.println(display);
        }
    }
}
