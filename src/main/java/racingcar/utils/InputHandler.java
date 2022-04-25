package racingcar.utils;

import racingcar.domain.Car;

import java.util.ArrayList;

public class InputHandler {

    public static ArrayList<Car> splitByComma(String requestInputCarName) {
        String[] result = requestInputCarName.split(",");
        ArrayList<Car> resultList = new ArrayList<>();

        for (String s : result) {
            resultList.add(new Car(s));
        }

        return resultList;
    }
}
