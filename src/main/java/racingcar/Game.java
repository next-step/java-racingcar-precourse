package racingcar;

public class Game {
    private TryNumber tryNumber;
    private Cars cars;

    public Game(Cars cars) {
        this.cars = cars;
    }

    public void setTryNumber(int tryNumber) {
        this.tryNumber = new TryNumber(tryNumber);
    }

    private void setCarsMaxMoveCount() {
        this.cars.setMaxMoveCount(tryNumber.getTryNumber());
    }

    public void start() {
        this.setCarsMaxMoveCount();

        boolean endGame = false;

        System.out.println("실행 결과");

        while (!endGame) {
            cars.move();
            cars.printCurrentMoveCount();

            System.out.println();
            System.out.println();

            endGame = cars.checkArriveCar();
        }

        System.out.println(cars.printArriveCarName());
    }
}
