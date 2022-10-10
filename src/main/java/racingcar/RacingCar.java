package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private final static String DISPLAY_MARK = "-";
    private final String carName;
    private int forward;

    public RacingCar(String carName) {
        this.carName = carName;
        this.forward = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getForward() {
        return forward;
    }

    public void playGame() {
        int randNum = Randoms.pickNumberInRange(0, 9);
        if (randNum >= 4) {
            this.forward += 1;
        }
    }

    public void display() {
        System.out.printf("%s : ", this.carName);
        for (int f=0;f<this.forward;f++){
            System.out.print(DISPLAY_MARK);
        }
        System.out.println();

    }
}
