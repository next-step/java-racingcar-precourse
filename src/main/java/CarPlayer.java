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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getCarName().toString() + " : ");

        for (int i = 0; i < this.car.getMoveCount(); i++) {
            sb.append("-");
        }

        return sb.toString();
    }
}
