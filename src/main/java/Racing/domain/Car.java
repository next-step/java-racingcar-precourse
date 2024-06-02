package Racing.domain;

public class Car {

    //자동차의 정보를 가지는 Car 도메인.
    private String name;
    private String distanceBar;

    //생성자
    public Car(String name) {
        this.name = name;
        this.distanceBar = "";

    }

    //Getter 및 Setter
    public String getDistanceBar() {
        return distanceBar;
    }

    public String getName() {
        return name;
    }

    public void plusDistanceBar() {
        this.distanceBar += "-";
    }

    public void setName(String name) {
        this.name = name;
    }
}
