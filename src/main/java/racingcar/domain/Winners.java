package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<CarName> nameList;

    public Winners() {
        nameList = new ArrayList<>();
    }

    public int size() {
        return nameList.size();
    }

    public void add(CarName winner) {
        nameList.add(winner);
    }

    public CarName get(IndexNumber index) {
        return nameList.get(index.getIndexNumber());
    }
}
