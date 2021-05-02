public class CarPlayer {
    private Car car;
    private RandomGenerator randomGenerator;

    public CarPlayer(CarName carname, RandomGenerator randomGenerator) {
        this.car = new Car(carname);
        this.randomGenerator = randomGenerator;
    }

    public void tryMoveCar() {
        this.car.tryMove(this.randomGenerator.get());
    }

    public int getMoveCount() {
        return this.car.getMoveCount();
    }
}
