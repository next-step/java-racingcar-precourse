import controller.RacerController;
import view.RacerView;

public class RacerApplication {
    public static void main(String[] args) {
        RacerView racerView = new RacerView(new RacerController());

        while (true) {
            racerView.render();
        }
    }
}
