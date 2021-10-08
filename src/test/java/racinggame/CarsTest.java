package racinggame;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {
    @Test
    void 레이싱참가_자동차_이름_중복() {
        assertEquals("레이싱 게임 참가 자동차의 이름은 중복될 수 없습니다.", assertThrows(IllegalArgumentException.class, () -> new Cars(Arrays.asList(new Car("dony"), new Car("dony")))).getMessage());
    }

    @Test
    void 레이싱게임_참가_자동차_없을때() {
        assertEquals("레이싱 게임 참가 자동차는 1대이상 이어야 합니다.", assertThrows(IllegalArgumentException.class, () -> new Cars()).getMessage());
    }

    @Test
    void 레이싱게임_참가_자동차들_객체생성_이름_다름() {
        Cars users = new Cars(Arrays.asList(new Car("dony"), new Car("chuny"), new Car("junny")));
        assertEquals(users.getUserCount(), 3);
    }
}
