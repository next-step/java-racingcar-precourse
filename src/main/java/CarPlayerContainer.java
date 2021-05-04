import java.util.ArrayList;
import java.util.List;

public class CarPlayerContainer {
    private static final String PLAYER_NAME_SEPERATE_STRING = ", ";

    private List<CarPlayer> carPlayers;

    public CarPlayerContainer() {
        this.carPlayers = new ArrayList<>();
    }

    public void add(CarPlayer carPlayer) {
        this.carPlayers.add(carPlayer);
    }

    public int size() {
        return this.carPlayers.size();
    }

    public CarPlayer get(int index) {
        return this.carPlayers.get(index);
    }

    public List<CarPlayer> getPlayers() {
        return this.carPlayers;
    }

    public CarPlayerContainer getWinners() {
        CarPlayerContainer winners = new CarPlayerContainer();
        int maxMoveCount = this.getMaxMoveCount();

        for (CarPlayer carPlayer : this.carPlayers) {
            this.tryWinner(carPlayer, maxMoveCount, winners);
        }

        return winners;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int lastIndex = this.carPlayers.size() - 1;

        for (int i = 0; i < lastIndex; i++) {
            sb.append(this.carPlayers.get(i).getPlayerName() + PLAYER_NAME_SEPERATE_STRING);
        }

        if (this.carPlayers.size() != 0) {
            sb.append(this.carPlayers.get(lastIndex).getPlayerName());
        }

        return sb.toString();
    }

    private int getMaxMoveCount() {
        int maxMoveCount = 0;

        for (CarPlayer carPlayer : this.carPlayers) {
            maxMoveCount = Math.max(maxMoveCount, carPlayer.getMoveCount());
        }

        return maxMoveCount;
    }

    private void tryWinner(CarPlayer carPlayer, int maxMoveCount, CarPlayerContainer winners) {
        if (carPlayer.getMoveCount() == maxMoveCount) {
            winners.add(carPlayer);
        }
    }
}
