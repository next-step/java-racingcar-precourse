public class CarPlayer {
    private Car car;
    private RandomGenerator randomGenerator;

    public CarPlayer(PlayerName playerName, RandomGenerator randomGenerator) {
        this.car = new Car(playerName);
        this.randomGenerator = randomGenerator;
    }

    public void tryMoveCar() {
        this.car.tryMove(this.randomGenerator.get());
    }

    public int getMoveCount() {
        return this.car.getMoveCount();
    }

    public PlayerName getPlayerName() {
        return this.car.getPlayerName();
    }

    @Override
    public String toString() {
        return this.car.toString();
    }
}
