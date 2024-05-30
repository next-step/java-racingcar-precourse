import controller.GameController;
import java.util.Scanner;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        new GameController(new OutputView(System.out), new Scanner(System.in)).playRacingCar();
    }
}
