package io;

import java.util.List;

import models.Car;

public class Result {
    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

}
