package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CarStatusGenerator {

    private static final int MIN_CAR_MOVERANEGE = 0;
    private static final int MAX_CAR_MOVERANEGE = 9;

    public List<CarStatus> generateRandomStatus(int carCount){

        List<CarStatus> carStatusList = new ArrayList<>();

        for(int i=0; i<carCount; ++i){
            int randomNumber = Randoms.pickNumberInRange(MIN_CAR_MOVERANEGE, MAX_CAR_MOVERANEGE);
            carStatusList.add(CarStatus.checkBackOrFoward(randomNumber));
        }

        return carStatusList;
    }
}
