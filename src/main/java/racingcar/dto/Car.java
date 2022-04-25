package racingcar.dto;

public class Car {
    public static final int MIN_NUM_FOR_RUN = 4;

    private CarName carName;
    private int run;
    private int stop;

    public Car(CarName carName) {
        this.carName = carName;
        this.run = 0;
        this.stop = 0;
    }

    public CarStatus operate(int i) {
        if (i >= MIN_NUM_FOR_RUN) {
            this.run += 1;
            return CarStatus.MOVING_FORWARD;
        }

        this.stop += 1;
        return CarStatus.STOP;
    }

    public CarName getCarName() {
        return this.carName;
    }

    public int getRun() {
        return this.run;
    }

    public int getStop() {
        return this.stop;
    }

    public void carLocation(int count) {
        System.out.print(this.carName.getName() + " : ");
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
