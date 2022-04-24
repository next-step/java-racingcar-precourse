package racingcar.domain;

import java.util.Objects;

public class Distance {

    private int amount;

    public Distance(int amount) {
        this.amount = amount;
    }

    public void add() {
        amount++;
    }

    public boolean longerThen(Distance longest) {
        return amount > longest.getAmount();
    }

    public int getAmount() {
        return amount;
    }
    
    @Override
    public String toString() {
        return "Distance{" +
            "amount=" + amount +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Distance distance = (Distance) o;
        return amount == distance.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
