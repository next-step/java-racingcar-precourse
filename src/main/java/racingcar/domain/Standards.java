package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Standards {
    List<Standard> standards;

    public Standards(List<Standard> standards) {
        this.standards = standards;
    }

    public Standard get(int index) {
        return standards.get(index);
    }

    public static Standards getStandardsByRandom(int size) {
        List<Standard> result = new ArrayList<>(size);
        while (size > 0) {
            Standard standard = new Standard(Randoms.pickNumberInRange(0, 9));
            result.add(standard);
            size--;
        }
        return new Standards(result);
    }

}
