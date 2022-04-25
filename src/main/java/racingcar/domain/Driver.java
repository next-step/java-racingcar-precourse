package racingcar.domain;

public class Driver {
    private final String name;
    private String distance;

    public String getName() {
        return name;
    }

    public String getDistance() {
        return distance;
    }

    public Driver(String name) {
        this.name = name;
        this.distance = "";
    }

    public String move(int i) {
        if(i>=4){
            this.distance += "-";
        }

        return this.distance;
    }
}
