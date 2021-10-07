package racinggame.car;

public class Car {
    private CarName carName;
    private CarProgress carProgress;
    int length = 0;

    public Car(){}

    public Car(String carName) throws Exception {
        this.carName = new CarName(carName);
        this.carProgress = new CarProgress();
    }

    public void setCarName(CarName carName) {
        this.carName = carName;
    }

    public void setCarProgress(CarProgress carProgress) {
        this.carProgress = carProgress;
    }

    public CarName getCarName() {
        return carName;
    }

    public CarProgress getCarProgress() {
        return carProgress;
    }

    public int go(int num) {
        if (num > 3) {
            return carProgress.plus();
        }
        return carProgress.get();
    }

    public String toString() {
        StringBuilder carInfo = new StringBuilder();
        carInfo.append(carName.toString());
        carInfo.append(" : ");
        carInfo.append(carProgress.toString());
        return carInfo.toString();
    }

}
