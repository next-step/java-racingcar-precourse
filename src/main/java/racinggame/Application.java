package racinggame;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        GameController gameController = new GameController();
        boolean again = true;
        while (again) {
            String[] carNames = gameController.printEnterCarNames();
            again = gameController.createCars(carNames);
        }

    }
}
