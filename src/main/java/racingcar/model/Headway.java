package racingcar.model;

import racingcar.constant.Digit;
import racingcar.constant.Sign;

public class Headway {

    private int headway;

    Headway() {
        this.headway = Digit.ZERO.getNumber();
    }

    public int getHeadway() {
        return this.headway;
    }

    public boolean isEqual(int headway) {
        return this.headway == headway;
    }

    public void addHeadway() {
        this.headway++;
    }

    public String getHeadwaySign() {
        StringBuffer sign = new StringBuffer("");
        for (int repeat = Digit.ZERO.getNumber(); repeat < this.getHeadway(); repeat++) {
            sign.append(Sign.HEADWAY_SIGN.getSign());
        }
        return sign.toString();
    }

    public void setMax(int headway) {
        if (this.headway < headway) {
            this.headway = headway;
        }
    }
}
