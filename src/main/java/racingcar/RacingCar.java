package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    private int totalDistance;


    private RacingCar() {
    }

    private RacingCar(String name) {
        this.name = name;
    }

    public static RacingCar getNewInstance(String name) {
        return new RacingCar(name);
    }

    public String getName() {
        return name;
    }

    public void start() {
        incrementDistance(Randoms.pickNumberInRange(0, 9));
        printDistance();
    }

    private void incrementDistance(int distance) {
        if (validationGeneratedDistance(distance)) {
            this.totalDistance += distance;
        }
    }

    private boolean validationGeneratedDistance(int distance) {
        return distance >= 4;
    }

    public void printDistance() {
        System.out.print(getName()+" : ");
        for (int i = 0; i < getTotalDistance(); i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    public int getTotalDistance() {
        return totalDistance;
    }
}
