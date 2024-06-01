package dto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @Test
    void carName() {
        // 이름 중에 공백이 있을 경우
        assertThrows(IllegalArgumentException.class, () -> new CarName(""));
        assertThrows(IllegalArgumentException.class, () -> new CarName(",a"));
        assertThrows(IllegalArgumentException.class, () -> new CarName("a,"));
        assertThrows(IllegalArgumentException.class, () -> new CarName(","));

        // 이름이 5자를 초과할 경우
        assertThrows(IllegalArgumentException.class, () -> new CarName("123456"));
        assertThrows(IllegalArgumentException.class, () -> new CarName("1234,123456"));

        // 정상 케이스
        CarName carName = new CarName("a,b,c");
        assertEquals(3, carName.getNameList().size());
        assertEquals(carName.getNameList(), List.of("a", "b", "c"));

        carName = new CarName("ㅁㄴㅇㄹ,ㅇ");
        assertEquals(2, carName.getNameList().size());
        assertEquals(carName.getNameList(), List.of("ㅁㄴㅇㄹ", "ㅇ"));
    }

}