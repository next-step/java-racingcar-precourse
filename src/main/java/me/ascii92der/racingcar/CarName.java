package me.ascii92der.racingcar;

import java.util.Objects;

public class CarName {
    private final String name;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    public CarName(String name) {
        if(validName(name)){
            throw new IllegalArgumentException("자동차 이름은 5자까지만 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
    boolean validName(String name){
        return !(name.length()>=MIN_NAME_LENGTH && name.length()<=MAX_NAME_LENGTH);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }
}
