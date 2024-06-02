import controller.GamePlay;
import java.util.Scanner;
import view.InputView;

public class Application {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    InputView inputView = new InputView(scanner);
    GamePlay gameplay = new GamePlay();

    inputView.InputInit();
    gameplay.init();
    gameplay.play();
  }
}
