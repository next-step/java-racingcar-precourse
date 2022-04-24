package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    public static final int GO_AHEAD_NUMBER = 4;

    private final CarName name;
    private int step;

    public RacingCar(CarName name) {
        this.name = name;
        this.step = 0;
    }

    public String getName() { return this.name.getName(); }

    public void move() {
        int range = Randoms.pickNumberInRange(0, 9);
        if (range >= GO_AHEAD_NUMBER) this.step++;
    }

    public int isWinStep(int winStep) {
        return Math.max(winStep, step);
    }

    public void addWinRacingCar(int winStep, Winners winners) {
        if (winStep == step) winners.addRacingCar(this.getName());
    }

    public void printState() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getName()).append(" : ");
        for (int i = 0; i < step; i++) {
            builder.append("-");
        }
        System.out.println(builder);
    }
}
