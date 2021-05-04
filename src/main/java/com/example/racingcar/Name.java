package com.example.racingcar;

public class Name {
    private static final int ZERO_LENGTH = 0;
    private static final int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        if (name == null || name.length() == ZERO_LENGTH) {
            throw new IllegalArgumentException("이름이 null이거나 이름길이가 0입니다.");
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("최대 이름길이를 초과하였습니다.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
