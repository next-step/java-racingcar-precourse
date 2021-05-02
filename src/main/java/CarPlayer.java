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

    public CarName getCarName() {
        return this.car.getCarName();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.car.getCarName().toString() + " : ");

        for (int i = 0; i < this.car.getMoveCount(); i++) {
            sb.append("-");
        }

        sb.append(String.format(" (%d)", this.car.getMoveCount()));

        return sb.toString();
    }
}
