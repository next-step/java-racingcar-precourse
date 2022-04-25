package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class RaceResult {

    public static final String EMPTY_STRING = "";
    public static final String RACE_TO_STRING_FORMAT = "%s : %s\n";

    private final Map<String, String> map;

    private RaceResult(Map<String, String> map) {
        this.map = map;
    }

    public static RaceResult of(Cars cars) {
        Map<String, String> map = new HashMap<>();
        for (Car car : cars.toList()) {
            map.put(car.getName(), car.getMovedDistance());
        }
        return new RaceResult(map);
    }

    public int longestDistance() {
        int longestDistance = Integer.MIN_VALUE;
        for (String key : map.keySet()) {
            String distance = map.get(key);
            longestDistance = Math.max(longestDistance, distance.length());
        }

        return longestDistance;
    }

    public Map<String, String> eachCarPosition() {
        return map;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(EMPTY_STRING);
        for (String key : map.keySet()) {
            String item = map.get(key);
            sb.append(String.format(RACE_TO_STRING_FORMAT, key, item));
        }

        return sb.toString();
    }
}
