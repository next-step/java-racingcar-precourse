package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private List<String> winners;

    public Winners() {
        this.winners = new ArrayList<>();
    }

    public void add(String name) {
        winners.add(name);
    }

    public List<String> getWinnerList() {
        return this.winners;
    }

    public int size() {
        return winners.size();
    }
}
