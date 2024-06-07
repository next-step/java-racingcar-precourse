package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("Car");
    }

    @Test
    @DisplayName("초기화시 객체의 상태 체크")
    void initialCarCheck() {
        // given
        String expectedName = "Car";
        int expectedPosition = 0;

        // when
        String actualName = car.getName();
        int actualPosition = car.getPosition();

        // then
        assertEquals(expectedName, actualName);
        assertEquals(expectedPosition, actualPosition);
    }

    @Test
    @DisplayName("이동 조건을 충족시 앞으로 한칸 전진")
    void satisfyMoveConditionGoOne() {
        // given
        int initialPosition = car.getPosition();
        int randomNumber = 5;

        // when
        car.move(randomNumber);
        int newPosition = car.getPosition();

        // then
        assertEquals(initialPosition + 1, newPosition);
    }

    @Test
    @DisplayName("이동 조건 불충족시 제자리")
    void 이동_테스트_이동_조건_불충족() {
        // given
        int initialPosition = car.getPosition();
        int randomNumber = 3;

        // when
        car.move(randomNumber);
        int newPosition = car.getPosition();

        // then
        assertEquals(initialPosition, newPosition);
    }
}
