package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.Constant;
import racingcar.domain.Car;
import racingcar.domain.Name;
import racingcar.domain.Position;
import java.util.ArrayList;
import java.util.List;

public class Input {
    private String input;

    public Input() {
        this.input = Console.readLine();
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public List<Car> splitCarNames(String input){
        List<Car> addCarsList = new ArrayList<>();
        for (String carName : input.split(Constant.COMMA) ) {
            Car car = new Car(new Name(carName), new Position(0));
            addCarsList.add(car);
        }
        return addCarsList;
    }
}
