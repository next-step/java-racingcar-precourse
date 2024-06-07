package model;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Cars {

    private HashMap<String, String> cars = new HashMap<>();

    public void setCars(String[] carNames) {
        for (String carName : carNames) {
            cars.put(carName, "");
        }
    }

    public void addDistance(String carName) {
        String curDist = cars.get(carName);
        cars.put(carName, curDist + "-");
    }

    public HashMap<String, String> getCars() {
        return cars;
    }

    /**
     * 우승자들을 뽑아내는 함수
     *
     * @return 우승자 이름들
     */
    public String[] getWinners() {
        ArrayList<String> winners = new ArrayList<>();
        String maxDistance = Collections.max(cars.values());
        for (String carName : cars.keySet()) {
            if (cars.get(carName).equals(maxDistance)) {
                winners.add(carName);
            }
        }
        return winners.stream().toArray(String[]::new);
    }
}
