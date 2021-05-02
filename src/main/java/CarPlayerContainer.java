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
}
