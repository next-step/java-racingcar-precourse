package utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private int startNumber;

    private int endNumber;


    public RandomNumber(int startNumber, int endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    public int getNumber(){
        return Randoms.pickNumberInRange(startNumber,endNumber);
    }
}
