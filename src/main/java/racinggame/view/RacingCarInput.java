package racinggame.view;

import java.util.ArrayList;

public class RacingCarInput {
    private int repeactCount = 0;

    RacingCarInput(){
    }

    public String[] splitCarNames(String carNames){
        String[] splitedCarNames;
        splitedCarNames = carNames.split(",");
        return splitedCarNames;
    }

    public boolean isEmptySpace(String carNames){
        boolean isEmptyContain = carNames.contains(" ");
        return isEmptyContain;
    }
}
