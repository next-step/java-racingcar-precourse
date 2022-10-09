package racingcar.domain;

import racingcar.common.CarMessage;
import racingcar.common.ExcMessage;

import java.util.List;

public class Winner {

    private  String carName;

    public String getCarName(String name){
       return ExcMessage.WINNER+name;
    }

    public String getCarName(List<Car> cars,int maxScore){
        String carName = "";
        for (Car car: cars) {
            if(maxScore == car.getPosition().getPosition()){
                carName += car.getCarName().getName()+ CarMessage.SEPARATOR+" ";
            }
        }
        return ExcMessage.WINNER+ carName.substring(0,carName.length()-2);
    }
}
