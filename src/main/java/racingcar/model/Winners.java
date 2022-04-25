package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<CarName> winners = new ArrayList<>();
    public Winners(List<CarName> winners){
        this.winners.addAll(winners);
    }
    public List<CarName> getWinners(){
        return winners;
    }
}
