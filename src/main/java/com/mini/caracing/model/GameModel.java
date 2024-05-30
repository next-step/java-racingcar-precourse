package com.mini.caracing.model;

import com.mini.caracing.util.GameUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class GameModel {

    private int totalMove;
    private LinkedHashMap<String, Integer> carDistances;

    public void initGameModel(List<String> carNames, int totalMove) {
        this.totalMove = totalMove;

        this.carDistances = new LinkedHashMap<>();
        for (String carName : carNames) {
            this.carDistances.put(carName, 0);
        }
    }

    public void updateCarDistances() {
        for (Map.Entry<String, Integer> entry : carDistances.entrySet()) {
            updateOneCarDistance(entry, GameUtil.randomDistance());
        }
    }

    public void updateOneCarDistance(Map.Entry<String, Integer> entry, int distance) {
        entry.setValue(entry.getValue() + distance);
    }

    public List<String> getWinnerList() {
        List<String> winnerList = new ArrayList<>();
        int maxDistance = GameUtil.getMaxDistance(carDistances);

        for (Map.Entry<String, Integer> entry : carDistances.entrySet()) {
            if (entry.getValue() == maxDistance) {
                winnerList.add(entry.getKey());
            }
        }

        return winnerList;
    }

    public LinkedHashMap<String, Integer> getCarDistances() {
        return carDistances;
    }

    public int getTotalMove() {
        return totalMove;
    }
}
