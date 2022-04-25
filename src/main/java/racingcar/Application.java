package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Cars cars = new Cars();
        RaceGame raceGame = new RaceGame();
        cars.addCar(raceGame.inputArray(raceGame.inputCarName()),raceGame.inputGameCount());
        cars.startGame();
    }
}
