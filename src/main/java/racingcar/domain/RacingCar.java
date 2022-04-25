package racingcar.domain;

import static racingcar.common.CommonVariable.ERROR_MESSAGE;
import static racingcar.common.CommonVariable.ERROR_MESSAGE_INPUT_IS_NULLE;
import static racingcar.common.CommonVariable.ERROR_MESSAGE_RACING_CAR_NAME_IS_OVER_SIX;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.platform.commons.util.StringUtils;

public class RacingCar implements Comparable<RacingCar>{
    final private String name;
    private int travel;
    private StringBuilder stringBuilder;

    private RacingCar(String name){
        this.name = racingCarCreateValidation(name);
        this.travel = 0;
        stringBuilder = new StringBuilder();
    }

    public String getName() {
        return name;
    }

    public int getTravel() {
        return travel;
    }

    public String showGoToDistance(){
        stringBuilder.setLength(0);
        for (int i =0; i < travel; i++){
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public void runRacing() {
        this.travel = this.travel + goTravel();
    }

    private int goTravel(){
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue < 4){
            return 0;
        }
        return 1;
    }

    public static RacingCar getInstance(String name){
        return new RacingCar(name);
    }

    private String racingCarCreateValidation(String name){
        if (StringUtils.isBlank(name)){
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_MESSAGE_INPUT_IS_NULLE);
        }
        if (name.length() > 5){
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_MESSAGE_RACING_CAR_NAME_IS_OVER_SIX);
        }
        return name;
    }

    @Override
    public int compareTo(RacingCar o) {
        return o.getTravel() - getTravel();
    }
}
