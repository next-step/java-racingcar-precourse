package com.racingcar.util;

public interface RandomGenerator<T> {

    T generate(Integer seed);
}
