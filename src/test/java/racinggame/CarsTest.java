package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.ErrorCode;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {
    private Cars users;

    @BeforeEach
    void setUp() {
        users = new Cars(Arrays.asList(new Car("dony"), new Car("chuny"), new Car("junny")));
    }

    @Test
    void 레이싱참가_자동차_이름_중복() {
        assertEquals("[ERROR] 레이싱 게임 참가 자동차의 이름은 중복될 수 없습니다.", assertThrows(IllegalArgumentException.class, () -> new Cars(Arrays.asList(new Car("dony"), new Car("dony")))).getMessage());
    }

    @Test
    void 레이싱게임_참가_자동차_없을때() {
        assertEquals("[ERROR] 레이싱 게임 참가 자동차는 1대이상 이어야 합니다.", assertThrows(IllegalArgumentException.class, () -> new Cars()).getMessage());
    }

    @Test
    void 레이싱게임_참가_자동차들_객체생성_이름_다름() {
        assertEquals(users.getUserCount(), 3);
    }

    @Test
    void 레이싱게임_참가_자동차_가져오기() {
        List<Car> cars = users.getUsers();
        assertEquals(cars.get(0).getName(), "dony");
        assertEquals(cars.get(1).getName(), "chuny");
        assertEquals(cars.get(2).getName(), "junny");
    }

    @Test
    void 레이싱게임_중_가장_앞에있는_자동차_포지션_가져오기() {
        List<Car> cars = users.getUsers();
        cars.get(0).move(5);
        cars.get(1).move(3);
        cars.get(2).move(1);

        assertEquals(users.getMaxPosition(), 1);

        cars.get(0).move(5);
        cars.get(1).move(3);
        cars.get(2).move(1);

        assertEquals(users.getMaxPosition(), 2);

    }
}
