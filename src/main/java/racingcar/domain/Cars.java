package racingcar.domain;

import racingcar.common.MessageMaker;

import java.util.*;

public class Cars {

    private final String CARS_SPLIT_STRING = ",";

    private List<Car> carList = new ArrayList<>();

    public Cars(){}

    public Cars(String cars) {
        validateCarSize(cars);
        validdateDuplicateName(cars);
        settingCarList(cars);
    }

    private void settingCarList(String cars){
        for(String name : cars.split(CARS_SPLIT_STRING)){
            Car car = new Car(name);
            this.carList.add(car);
        }
    }

    public List<Car> getCarList(){
        return this.carList;
    }

    private void validateCarSize(String cars) {
        if (cars.split(CARS_SPLIT_STRING).length == 1) {
            throw new IllegalArgumentException(MessageMaker.consoleOutErrorMessage("자동차 이름을 한 대 이상 입력해야 경주를 할 수 있습니다."));
        }
    }

    private void validdateDuplicateName(String cars) {
        String[] names = cars.split(CARS_SPLIT_STRING);
        Set<String> carSet = new HashSet<>(Arrays.asList(names));
        if (names.length != carSet.size()) {
            throw new IllegalArgumentException(MessageMaker.consoleOutErrorMessage("중복된 자동차 이름은 사용 할 수 없습니다."));
        }
    }
}
