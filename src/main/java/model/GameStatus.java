package model;
import java.util.ArrayList;

import java.util.HashMap;

public class GameStatus {
    HashMap<String, Integer> tryCurrent = new HashMap<>();
    ArrayList winners = new ArrayList();

    int tryGoal;

    public void setTryGoal(int tryGoal) {
        this.tryGoal = tryGoal;
    }

    public int getTryGoal() {
        return tryGoal;
    }

    public void initTryCurrent(String[] args) {
        for (int i = 0; i < args.length; i++) {
            tryCurrent.put(args[i], 0);
        }
    }

    public void updateTryCurrent(String args) {
        int currentKey = tryCurrent.get(args);
        tryCurrent.put(args, currentKey + 1);
    }

    public void setWinners(String[] args) {
        for (int i = 0; i < args.length; i++) {
            this.winners.add(i, args[i]);
        }
    }

    public HashMap<String, Integer> getTryCurrent() {
        return this.tryCurrent;
    }

    public ArrayList getWinners() {
        return this.winners;
    }
}
