package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.UserInterFace;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.Constants.ErrorMessage.CAR_NAME_DUPLICATED_ERR_MSG;

public class Cars {

    private static final String WINNER_CAR_NAMES_DELIMITER = ",";
    private final List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = cars;
        validateDuplicatedCarName();
    }

    public void validateDuplicatedCarName(){
        Set<String> carNames = new HashSet<>();
        for (Car car : cars) {
            carNames.add(car.toString());
        }
        if(carNames.size() != cars.size()){
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED_ERR_MSG);
        }
    }

    public void moveCars(){
        for (Car car : cars) {
            car.move(generateRandomNumber());
            car.printCarNameAndPosition();
        }
        UserInterFace.printMsg("");
    }

    private int generateRandomNumber(){
        return Randoms.pickNumberInRange(1,9);
    }

    public Cars extractWinners(){
        List<Car> winners = new ArrayList<>();
        cars.sort(Car::compareTo);
        winners.add(cars.get(0));
        for (int i = 1; i < cars.size(); i++) {
            if(cars.get(i-1).equals(cars.get(i))){
                winners.add(cars.get(i));
            }
        }
        return new Cars(winners);
    }

    public String extractCarNames(){
        StringBuffer sb = new StringBuffer();
        for (Car car : cars) {
            sb.append(car.getCarName());
            sb.append(WINNER_CAR_NAMES_DELIMITER);
        }
        String carNames = sb.toString();
        return carNames.substring(0,carNames.length()-1);
    }

}
