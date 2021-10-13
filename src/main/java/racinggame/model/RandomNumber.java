package racinggame.model;

import nextstep.utils.Randoms;

public class RandomNumber {
    private int randomNumber;

    public int getRandomNumber() {
        return randomNumber;
    }

    public int playRound() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
