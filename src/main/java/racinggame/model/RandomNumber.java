package racinggame.model;

import nextstep.utils.Randoms;

public class RandomNumber {
    private int randomNumber;

    public RandomNumber() {
        this.randomNumber = 0;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void playRound() {
        this.randomNumber = Randoms.pickNumberInRange(0, 9);
    }

}
