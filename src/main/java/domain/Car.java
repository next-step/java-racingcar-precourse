package domain;

public class Car {
    private String name;
    private Integer distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void next() {
        int randNum = (int) (Math.random() * 10);
        if (randNum >= 4) {
            this.distance++;
        }
    }

    @Override
    public String toString() {
        return this.name + " : " + "-".repeat(this.distance);
    }

    public String getName() {
        return this.name;
    }

    public Integer getDistance() {
        return this.distance;
    }
}
