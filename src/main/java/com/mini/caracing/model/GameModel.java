package com.mini.caracing.model;

import com.mini.caracing.util.GameUtil;
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

    public void updateOneCarDistance(Map.Entry<String, Integer> entry, int distance){
        entry.setValue(entry.getValue() + distance);
    }

    public LinkedHashMap<String, Integer> getCarDistances() {
        return carDistances;
    }
}
