import Controller.RaceController;

public class Application {

    public static void main(String[] args) {
        RaceController race = new RaceController();
        race.inputName();
        race.inputCount();
        race.round();
        race.finish();
    }
}
