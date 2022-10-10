package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomAction {
    private RacingCarAction racingCarAction;

    public RandomAction(){
        this.racingCarAction = getRandomCarAction(generateRandomNum());
    }

    public int generateRandomNum() {
        int randomNum = pickNumberInRange(ValidationUtils.MIN_NUMBER, ValidationUtils.MAX_NUMBER);
        if(ValidationUtils.isValidNum(randomNum)){
            return randomNum;
        }
        return generateRandomNum();
    }

    public RacingCarAction getRandomCarAction(int randomNum) {
        if(randomNum < ValidationUtils.BOUNDARY_NUM) return RacingCarAction.STOP;
        return RacingCarAction.GO;
    }

    public RacingCarAction getRacingCarAction() {
        return racingCarAction;
    }
}
