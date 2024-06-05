package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("Car");
    }

    @Test
    public void 초기_상태_테스트() {
        // given
        String expectedName = "Car";
        int expectedPosition = 0;

        // when
        String actualName = car.getName();
        int actualPosition = car.getPosition();

        // then
        assertEquals(expectedName, actualName, "자동차의 이름은 생성자에서 설정한 값과 같아야 한다.");
        assertEquals(expectedPosition, actualPosition, "자동차의 초기 위치는 0이어야 한다.");
    }

    @Test
    public void 이동_테스트_이동_조건_충족() {
        // given
        int initialPosition = car.getPosition();
        int moveValue = 5;

        // when
        car.moveFront(moveValue);
        int newPosition = car.getPosition();

        // then
        assertEquals(initialPosition + 1, newPosition, "이동 조건을 충족할 때 자동차는 한 칸 이동해야 한다.");
    }

    @Test
    public void 이동_테스트_이동_조건_불충족() {
        // given
        int initialPosition = car.getPosition();
        int moveValue = 3;

        // when
        car.moveFront(moveValue);
        int newPosition = car.getPosition();

        // then
        assertEquals(initialPosition, newPosition, "이동 조건을 충족하지 않을 때 자동차는 이동하지 않아야 한다.");
    }
}
