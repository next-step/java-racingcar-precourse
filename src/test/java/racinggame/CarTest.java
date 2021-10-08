/*
 * CarTest
 * java-racingcar-precourse
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-10-08.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.utils.CarName;

public class CarTest {
    CarName carName;
    Car car;

    @BeforeEach
    void setUp() {
        carName = new CarName("이름");
        car = new Car(carName);
    }

    @Test
    public void 자동차_생성() throws Exception {
        Assertions.assertThat(car.getName()).isNotNull().isEqualTo(carName.get());
    }

    @Test
    public void 자동차_랜덤값_입력_동작() throws Exception {
        for (int i = 0; i < 5; i++) {
            car.action();
            System.out.println(car.toString());
        }
    }

    @Test
    public void 자동차_전진() throws Exception {
        //when
        car.forward();
        //then
        Assertions.assertThat(car.getPosition()).isNotNull().isEqualTo("-");
    }

}
