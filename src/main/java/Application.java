import controller.*;
import view.*;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        View view = new View();
        controller.play();
    }
}