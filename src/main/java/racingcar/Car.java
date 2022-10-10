package racingcar;

public class Car {
    private CarName carName;
    private MoveDistance moveDistance;

    public Car(String carName) {
        this.carName = new CarName(carName);
        moveDistance = new MoveDistance();
    }

    public boolean isCarNameCollect() {
        if (carName.carNameLength() > 5) {
            throw new IllegalArgumentException("[ERROR] 차 이름은 5자 이하입니다");
        }

        return true;
    }

    public void goOrStop(CarStatus carStatus) {
        if (carStatus == CarStatus.GO) {
            moveDistance.increaseDistance();
        }
    }

    private String MoveDistanceString() {
        String moveDistanceString = "";
        for (int i = 0; i < moveDistance.getMoveDistance(); i++) {
            moveDistanceString += "-";
        }
        return moveDistanceString;
    }

    public String printStatusString() {
        return carName.getCarName() + " : " + MoveDistanceString();
    }

    public int getMoveDistance() {
        return moveDistance.getMoveDistance();
    }

    public String getCarName() {
        return carName.getCarName();
    }
}
