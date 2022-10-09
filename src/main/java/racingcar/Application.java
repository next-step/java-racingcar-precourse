package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceStart();
    }

    private static void RaceStart() {
        Race race= new Race();
        race.start();
    }
}
