package domain;

public class Car {
    private String name;
    private int raceDistance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



    public int getRaceDistance() {
        return raceDistance;
    }
    public void forward(){
        ++raceDistance;
    }
}
