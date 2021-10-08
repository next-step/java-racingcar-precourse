/*
 * CarComparator
 * java-racingcar-precourse
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-10-08.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame.utils;

import racinggame.domain.Car;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        if (car1.getPosition().length() == car2.getPosition().length()) {
            return car1.getId().get() - car2.getId().get();
        }
        return car2.getPosition().length() - car1.getPosition().length();
    }
}