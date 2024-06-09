package app.model;

import java.util.Random;

public class RacingCar {
    private String name;
    private int location;

    public RacingCar(String name) {
        this.name = name;
        this.location = 0;
    }

    public void printCurLocation() {
        System.out.println(this.name + " : " + "-".repeat(location));
    }

    public void moveForward() {     // 전진할지 말지 판단한 후, 전진하면 location 값 +1
        if (new Random().nextInt(10) >= 4) {
            this.location++;
        }
    }

}
