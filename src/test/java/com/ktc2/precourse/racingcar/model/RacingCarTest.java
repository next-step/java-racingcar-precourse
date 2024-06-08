package com.ktc2.precourse.racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    @DisplayName("자동차 전진을 시도하면 아무일도 없거나 한 칸 앞으로 가는지 테스트")
    void tryMoveForward() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int pos = random.nextInt(0, 10000);
            RacingCar car = new RacingCar("name", pos);
            car = car.tryMoveForward();
            //앞으로 이동을 시도한 후 위치가 그대로이거나 아니면 한 칸 앞으로 간 경우인지 확인
            //위치가 그대로가 아니라면 반드시 한 칸 앞으로 전진한 상태여야 함
            assertTrue((car.position() == pos) != (car.position() == pos + 1));
        }
    }

    @Test
    @DisplayName("자동차의 위치를 얻을 수 있는지 테스트")
    void position() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int pos = random.nextInt(0, 10000);
            assertEquals(new RacingCar("name", pos).position(), pos);
        }
    }
}