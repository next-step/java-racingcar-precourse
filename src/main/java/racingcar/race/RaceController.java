package racingcar.race;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.view.RaceView;

public class RaceController {
    
    public static final String ERROR_INPUT_ROUND_FORMAT = "[ERROR] 라운드는 숫자로 입력해주세요";
    public static final String ERROR_INPUT_EMPTY = "[ERROR] 입력이 비어있습니다.";
    public static final String ERROR_INPUT_DUPLICATE = "[ERROR] 중복 값이 있습니다.";
    
    public void start(){
        Cars cars = stringToCars(getCarNames());
        Race race = new Race(cars);
        int roundNum = getRoundNum();

        while(race.getRound() < roundNum){
            race.inputScoresToCars();
            RaceView.roundResultView(race.getResultMap());
            race.finishRound();
        }
        RaceView.resultView(race.getWinners());
    }
    public String getCarNames(){
        try {
            String namesOfCars = RaceView.startView().trim();
            validateNames(namesOfCars);
            return namesOfCars;
        } catch (IllegalArgumentException ex) {
            RaceView.outputView(ex.getLocalizedMessage());
            return getCarNames();
        }
    }
    public int getRoundNum(){
        try {
            String ronundNum = RaceView.roundView();
            return Integer.valueOf(ronundNum).intValue();
        } catch (NumberFormatException ex) {
            RaceView.outputView(ex.getLocalizedMessage());
            return getRoundNum();
        }
    }
    public Cars stringToCars(String namesOfCars){
        List<Car> carList = new ArrayList<Car>();
        for (String name : namesOfCars.split(",")){
            carList.add(new Car(name));
        };
        return new Cars(carList);
    }

    public void validateNames(String namesOfCars){
        if (namesOfCars.isEmpty()){
            throw new IllegalArgumentException(ERROR_INPUT_EMPTY);
        }

        validateNameDuplicate(namesOfCars);

        for (String name : namesOfCars.split(",")){
            validateNameLength(name);
        };
    }

    private void validateNameDuplicate(String namesOfCars){
        List<String> nameList = new ArrayList<>();
        for (String name : namesOfCars.split(",")){
            nameList.add(name);
        }
        Set<String> nameSet = new HashSet(nameList);
        if (nameList.size() != nameSet.size()){
            throw new IllegalArgumentException(ERROR_INPUT_DUPLICATE);
        }
    }

    private void validateNameLength(String name) {
        Car.validateNameLength(name);
    }
}
