package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CarLocation {
    private final StringBuilder location;

    public CarLocation(){
        location = new StringBuilder();
    }

    public void goStop(){
        if(pickNumberInRange(0, 9) >= 4){
            location.append("-");
        }
    }

    public StringBuilder getLocation() {
        return location;
    }
}
