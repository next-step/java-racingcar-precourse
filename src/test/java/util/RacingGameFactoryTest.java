package util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class RacingGameFactoryTest {

    @Test
    void prepareRacingCar_ValidInput() {
        RacingGameFactory factory = new RacingGameFactory();
        assertDoesNotThrow(() -> factory.prepareRacingCar("Car1,Car2,Car3"));
    }


    @Test
    void prepareRacingCar_EmptyName() {
        RacingGameFactory factory = new RacingGameFactory();
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            factory.prepareRacingCar("Car1,,Car3");
        });
        assertTrue(thrown.getMessage().contains("이름이 비어있음"));
    }

    @Test
    void prepareRacingCar_ContainsSpace() {
        RacingGameFactory factory = new RacingGameFactory();
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            factory.prepareRacingCar("Car 1,Car2,Car3");
        });
        assertTrue(thrown.getMessage().contains("공백이 포함됌"));
    }

    @Test
    void prepareRacingCar_NameTooLong() {
        RacingGameFactory factory = new RacingGameFactory();
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            factory.prepareRacingCar("Car123456,Car2,Car3");
        });
        assertTrue(thrown.getMessage().contains("5자를 넘어감"));
    }
    @Test
    void prepareRacingCar_vaildCarNum() {
        RacingGameFactory factory = new RacingGameFactory();
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            factory.prepareRacingCar("Car1");
        });
        assertTrue(thrown.getMessage().contains("참가 자동차수는 하나보다는 커야함"));
    }

    @Test
    void prepareRound_ValidInput() {
        RacingGameFactory factory = new RacingGameFactory();
        assertDoesNotThrow(() -> factory.prepareRound("5"));
    }

    @Test
    void prepareRound_InvalidInput() {
        RacingGameFactory factory = new RacingGameFactory();
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            factory.prepareRound("abc");
        });
        assertEquals("라운드 횟수는 정수여야합니다.", thrown.getMessage());
    }

    @Test
    void prepareRound_OutOfRange() {
        RacingGameFactory factory = new RacingGameFactory();
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            factory.prepareRound("13");
        });
        assertEquals("라운드 횟수는 1~12 사이의 값이어야합니다.", thrown.getMessage());
    }

    @Test
    void getRacingGame_WithoutPreparation() {
        RacingGameFactory factory = new RacingGameFactory();
        NullPointerException thrown = assertThrows(NullPointerException.class, factory::getRacingGame);
        assertTrue(thrown.getMessage().contains("유효한 자동차 이름 목록이 비어있습니다.") || thrown.getMessage().contains("유효한 라운드 숫자가 설정되지 않았습니다."));
    }

    @Test
    void getRacingGame_AfterPreparation() {
        RacingGameFactory factory = new RacingGameFactory();
        factory.prepareRacingCar("Car1,Car2,Car3");
        factory.prepareRound("5");
        assertDoesNotThrow(factory::getRacingGame);
    }
}
