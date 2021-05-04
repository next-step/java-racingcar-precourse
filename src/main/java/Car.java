public class Car {
    private CarName carName;
    private CarProgress carProgress;

    public Car(String cn) {
        carName = new CarName(cn);
        carProgress = new CarProgress();
    }

    public Car(CarName cn) {
        carName = cn;
        carProgress = new CarProgress();
    }

    public void go(int num) {
        carProgress.moveForward(num);
    }

    public void go() {
        carProgress.moveForward(RandomNumber.getZero2Nine());
    }

    public String getCarNameStr() {
        return carName.toString();
    }

    public int getProgress() {
        return carProgress.getProgressNumber();
    }

    public String toString() {
        return carName.toString() + " : " + carProgress.toString();
    }
}
