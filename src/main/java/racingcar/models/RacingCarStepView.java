package racingcar.models;

public class RacingCarStepView {

    private final RacingCar car;
    private int step;

    public RacingCarStepView(RacingCar car, int step) {
        this.car = car;
        this.step = step;
    }

    public String getCarName() {
        return this.car.getName();
    }
    public String getStepString() {
        StringBuilder str = new StringBuilder();
        for (int i=0; i < step; i += 1) {
            str.append("-");
        }
        return str.toString();
    }
}
