package model;

public class GameSettings {
    int tryGoal;
    int numCars;

    void setTryGoal(int tryGoal) {
        this.tryGoal = tryGoal;
    }

    public int getTryGoal() {
        return tryGoal;
    }

    void setNumCars(int numCars) {
        this.numCars = numCars;
    }

    public int getNumCars() {
        return numCars;
    }
}