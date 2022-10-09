package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Coordinates {

    private final List<Integer> coordinates;

    public Coordinates(List<Integer> coordinates) {
        this.coordinates = coordinates;
    }

    public void setCoordinates(int count) {
        for (int i=0; i<count; i++) {
            this.coordinates.add(pickNumberInRange(0, 9));
        }
    }

    public static Coordinates generate(Integer ... coordinates) {
        List<Integer> coordinateList = new ArrayList<>(Arrays.asList(coordinates));
        return new Coordinates(coordinateList);
    }

    public int pop() {
        if (coordinates.size() == 0) {
            throw new IllegalArgumentException("[ERROR] 인덱스를 초과하여 좌표 추출하였습니다.");
        }
        return this.coordinates.remove(0);
    }
}
