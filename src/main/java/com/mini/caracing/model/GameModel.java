package com.mini.caracing.model;

import java.util.LinkedHashMap;
import java.util.List;

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
}
