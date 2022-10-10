package racingcar.entities;

import racingcar.utils.Move;

public class Car {

    public static final int INIT_DISTANCE = 0;
    public static final int RANDOM_NUMBER_START = 0;
    public static final int RANDOM_NUMBER_END = 9;
    public static final String DISTANCE_MARK = "-";
    private String distanceBar;
    private int distance;
    private final String name;
    private int randomNumber;

    public Car(int distance, String name) {
        this.distance = distance;
        this.name = name;

    }

    public Car(String name) {
        this.name = name;
        this.distance = INIT_DISTANCE;
        this.distanceBar = "";
    }


    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }


    public int getFurtherDistance(int maxDistance) {
        return Math.max(maxDistance, this.getDistance());
    }

    public boolean isCarWinner(int maxDistance) {
        return maxDistance == this.getDistance();
    }

    public void proceedGameOnce() {
        Move move = new Move();
        this.randomNumber = move.getRandomNumber(RANDOM_NUMBER_START, RANDOM_NUMBER_END);
        if (move.isCarMove(this.randomNumber)) {
            this.distance++;
            this.distanceBar+= DISTANCE_MARK;
        }
    }

    public int getRandomNumber() {
        return randomNumber;
    }
    public String getDistanceBar() {
        return distanceBar;
    }
}
