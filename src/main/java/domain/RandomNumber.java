package domain;

import java.util.Random;

public class RandomNumber {
    private int number = 0;

    public RandomNumber() {
        this.number = shuffle();
    }

    public int number(){
        return this.number;
    }

    private int shuffle() {
        return new Random().nextInt(10);
    }

}
