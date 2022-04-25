package racingcar;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;
    public static final int STOP = 3;
    private final String carName;
    private final int gameCount;
    public String result;

    public String getCarName() {
        return carName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Car(String carName, int gameCount) {
        this.carName = carName;
        this.gameCount = gameCount;
//        this.result = resultString(gameCount);
        this.result = "";
    }

    private String resultString(int gameCount) {
        String temp = "";
        for(int i = 0; i< gameCount; i++){
            temp += goAndStop(inputRandomNumber());
        }
        return temp;
    }

    public int inputRandomNumber() {
        return pickNumberInRange(MIN_NUM, MAX_NUM);
    }

    public String goAndStop(int randomNumber) {
        if(carCondition(randomNumber)) return "";
        return "-";
    }

    private boolean carCondition(int randomNumber) {
        return randomNumber <= STOP;
    }
}
