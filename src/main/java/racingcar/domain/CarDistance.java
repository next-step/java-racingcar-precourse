package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CarDistance {
    int distance = 0;
    final int AdvanceCondition = 4;
    final int RandomMinRange = 0;
    final int RandomMaxRange = 9;

    public CarDistance() {
    }

    public void nextStep(){
        int random = Randoms.pickNumberInRange(RandomMinRange, RandomMaxRange);
        if(random >= AdvanceCondition) advance();
    }

    public void advance(){
        distance++;
    }

    public int getDistance() {
        return distance;
    }
}
