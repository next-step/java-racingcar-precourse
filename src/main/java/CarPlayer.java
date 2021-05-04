public class CarPlayer {
    private Car car;
    private PlayerName playerName;
    private RandomGenerator randomGenerator;

    public CarPlayer(PlayerName playerName, RandomGenerator randomGenerator) {
        this.playerName = playerName;
        this.randomGenerator = randomGenerator;

        this.car = new Car();
    }

    public void tryMoveCar() {
        this.car.tryMove(this.randomGenerator.get());
    }

    public int getMoveCount() {
        return this.car.getMoveCount();
    }

    public PlayerName getPlayerName() {
        return this.playerName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.playerName.toString() + " : ");
        sb.append(this.car.toString());

        return sb.toString();
    }
}
