package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racing {
    private List<Car> carList;


    public Racing(String carListNames) {
        String[] cars = carListNames.split(",");
        carList = new ArrayList<>();
        for (String carName : cars) {
            carList.add(Car.withName(carName));
        }
    }

    public void moveCheck() {
        for (Car car : carList) {
            car.update();
            System.out.println(car.getLaps());
        }
    }

    public void getResult() {

        HashMap<String, Integer> result = new HashMap<>();

        for (Car car : carList) {
            result.put(car.getName(), car.getLapInfo().length());
        }

        ArrayList<String> max_list = new ArrayList<>();
        int maxValue = Collections.max(result.values());
        for (Map.Entry<String, Integer> m : result.entrySet()) {
            if (m.getValue() == maxValue) {
                max_list.add(m.getKey());
            }
        }

        String winners = Arrays.toString(max_list.toArray());
        System.out.println("최종 우승자: " + winners.replace("[", "").replace("]", ""));

    }
}