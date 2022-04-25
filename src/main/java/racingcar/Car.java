package racingcar;

public class Car {

    CarName carName;
    GoCount goCount;

    public Car() {

    }

    public Car(CarName carName) {
        this.carName = carName;
        this.goCount = new GoCount();
    }

    public void goForward(boolean bool) {
        if (bool) {
            this.goCount.go();
        }
    }

    public int nowPosition() {
        return goCount.nowPosition();
    }

    public void showNowPosition() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.carName.carName);
        stringBuilder.append(" : ");
        for (int i = 0; i < this.nowPosition(); i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString());
    }

    public String findWinner(int max) {
        if (goCount.nowPosition() == max) {
            return this.carName.carName + ", ";
        }
        return "";
    }
}
