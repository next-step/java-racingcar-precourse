package domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String name;
    private List<Integer> moveRound;

    public static Car from(String name) {
        return new Car(name, new ArrayList<>());
    }


    protected Car(String name, List<Integer> moveRound) {
        this.name = name;
        this.moveRound = moveRound;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMoveRound() {
        return moveRound;
    }

    public void move(int round) {
        this.moveRound.add(round);
    }
}
