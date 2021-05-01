package domain;

import java.util.Random;

public class Dice {
    public static final int MAX_VALUE = 9;
    public static final int MIN_VALUE = 1;
    private int ticks;

    public static Dice roll() {
        return new Dice();
    }

    private Dice() {
        Random random = new Random();
        this.ticks = random.nextInt(MAX_VALUE)+ MIN_VALUE;
    }

    public int getTicks() {
        return ticks;
    }

    public Dice(int ticks) {
        this.ticks = ticks;
    }
}
