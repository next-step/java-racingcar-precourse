package Application;
import java.util.*;
import java.lang.*;

public class RacingGameModel {
    private Map<String, Integer> carPositions;

    public RacingGameModel() {
        carPositions = new HashMap<>();
    }

    public void initializeGame(String[] carNames) {
        for(String name:carNames) carPositions.put(name.trim(), 0);
    }

    public void moveCars(Random random) {
        for(String name: carPositions.keySet()) {
            if(random.nextInt(10) >= 4) carPositions.put(name, carPositions.get(name)+1);
        }
    }

    public Map<String, Integer> getCarPositions() {
        return carPositions;
    }

    public List<String> getWinners() {
        int maxPosition = carPositions.values().stream().max(Integer::compare).orElse(0);
        List<String> winners = new ArrayList<>();
        for(Map.Entry<String, Integer> entry:carPositions.entrySet()) {
            if(entry.getValue() == maxPosition) winners.add(entry.getKey());
        }
        return winners;
    }
}
