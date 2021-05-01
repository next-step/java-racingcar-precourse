package com.bistros.racing.domain;

/**
 * 테스트 차량, (테스트 엔진을 장착하고 있다)
 */
public class TestCar extends Car {
    public TestCar(String name) {
        super(name, new TestEngine());
    }
}
