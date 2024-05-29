package Model;

public class Car {
    private String carName;
    private int positon;

    public Car(String carName, int positon) {
        nameTest(carName);
        this.carName = carName;
        this.positon = positon;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getPositon() {
        return positon;
    }

    public void setPositon(int positon) {
        this.positon = positon;
    }

    public void nameTest(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
        }

        if (carName.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백을 포함할 수 없습니다.");
        }
    }
}
