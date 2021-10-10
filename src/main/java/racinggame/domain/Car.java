package racinggame.domain;

public class Car {
    private CarName name;
    private CarDistance distance;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = new CarDistance();
    }

    public void changeDistance(int randomNumber) {
        this.distance.change(randomNumber);
    }

    public String convertDistanceToHyphen() {
        return this.distance.convertToHyphen();
    }

    public String getName() {
        return name.getCarName();
    }

    public int getDistance() {
        return distance.getCarDistance();
    }
}
