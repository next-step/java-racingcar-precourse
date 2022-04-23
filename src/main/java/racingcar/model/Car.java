package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int NAME_MAX_SIZE = 5;

    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 9;
    private static final int CONDITION = 4;

    private final String name;
    private int position;

    Car(String name) {
        if (NAME_MAX_SIZE < name.length())
            throw new IllegalArgumentException("Car name length is logger than " + NAME_MAX_SIZE);
        this.name = name;
        this.position = 0;
    }

    public void drive() {
        if (CONDITION <= Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM))
            position++;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++)
            builder.append("-");
        return builder.toString();
    }
}
