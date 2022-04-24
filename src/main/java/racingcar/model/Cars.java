package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import racingcar.utils.ValidationUtil;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(String cars) {
        this.cars = tokenizeCars(cars);
    }

    private List<Car> tokenizeCars(String cars){
        try{
            String[] tokenizedCars = cars.split(",");
            return Arrays.stream(tokenizedCars)
                    .peek(ValidationUtil::isCarNameValid)
                    .map(Car::new)
                    .collect(Collectors.toList());
        }catch (PatternSyntaxException exception){
            throw new IllegalArgumentException("[ERROR] car names must be tokenized by comma");
        }
    }

    public List<Car> moveForward(){
        cars.forEach(car -> car.createSteps(Randoms.pickNumberInRange(0,9)));
        return this.cars;
    }
}
