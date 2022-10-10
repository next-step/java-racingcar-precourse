package racingcar.domain;

import racingcar.utils.NumberRule;

public class RacingResult {

    private String carName;
    private int position;

    public RacingResult(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public void forwardPosition(boolean isForward) {
        this.position += isForward ? NumberRule.FORWARD_NUMBER.getValue() : 0;
    }

    public String getCarName() {
        return this.carName;
    }

    public Integer getPosition() {
        return this.position;
    }

    public RacingResult deepCopyOf() {
        return new RacingResult(this.carName, this.position);
    }

    @Override
    public String toString() {
        String printPosition = "";
        int printNumber = this.position;
        while(printNumber-- > 0) {
            printPosition += "-";
        }
        return carName + " : " + printPosition + "\n";
    }

}
