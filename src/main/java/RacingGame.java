import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGame {
    public static void main(String[] args) {
        RacingGameView view=new RacingGameView();
        RacingGameController controller=new RacingGameController(view);
        controller.startGame();
    }

}
