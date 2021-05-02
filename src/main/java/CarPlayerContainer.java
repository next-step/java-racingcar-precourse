import java.util.ArrayList;
import java.util.List;

public class CarPlayerContainer {
    private List<CarPlayer> carPlayers;

    public CarPlayerContainer() {
        this.carPlayers = new ArrayList<>();
    }

    public void add(CarPlayer carPlayer) {
        this.carPlayers.add(carPlayer);
    }

    public List<CarPlayer> getPlayers() {
        return this.carPlayers;
    }

    public List<CarPlayer> getWinners() {
        int maxMoveCount = this.getMaxMoveCount();

        List<CarPlayer> winners = new ArrayList<>();
        for (CarPlayer carPlayer : this.carPlayers) {
            this.tryWinner(carPlayer, maxMoveCount, winners);
        }

        return winners;
    }

    private int getMaxMoveCount() {
        int maxMoveCount = 0;

        for (CarPlayer carPlayer : this.carPlayers) {
            maxMoveCount = Math.max(maxMoveCount, carPlayer.getMoveCount());
        }

        return maxMoveCount;
    }

    private void tryWinner(CarPlayer carPlayer, int maxMoveCount, List<CarPlayer> winners) {
        if (carPlayer.getMoveCount() == maxMoveCount) {
            winners.add(carPlayer);
        }
    }
}
