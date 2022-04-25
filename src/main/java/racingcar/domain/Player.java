package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Player {

    private String name;

    private int headway;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeadway() {
        return headway;
    }

    public void setHeadway(int headway) {
        this.headway = headway;
    }

    public void plyeGame() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            int headwayCount = getHeadway() + 1;
            setHeadway(headwayCount);
        }
        System.out.print(getName() + " : ");
        for (int i = 0; i < getHeadway(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
