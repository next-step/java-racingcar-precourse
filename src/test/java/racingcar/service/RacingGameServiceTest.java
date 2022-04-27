package racingcar.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.racinggame.service.RacingGameService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;

public class RacingGameServiceTest {

    @Test
    @DisplayName("차 생성 공백 예외 테스트")
    void createCar_blank_exception_test() {
        RacingGameService racingGameService = new RacingGameService();

        String input = "";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            racingGameService.createCar();
        });
    }

    @Test
    @DisplayName("차 생성 0자 생성 예외 테스트")
    void createCar_zero_name_exception_test() {
        RacingGameService racingGameService = new RacingGameService();

        String input = "one,,three";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingGameService.createCar();
        });
    }

    @Test
    @DisplayName("차 생성 5자 이상 생성 예외 테스트")
    void createCar_five_upper_exception_test() {
        RacingGameService racingGameService = new RacingGameService();

        String input = "one,twotwo,three";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingGameService.createCar();
        });
    }

    @Test
    @DisplayName("차 생성 중복 이름 생성 예외 테스트")
    void createCar_duplicate_name_exception_test() {
        RacingGameService racingGameService = new RacingGameService();

        String input = "one,one,three";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingGameService.createCar();
        });
    }

    @Test
    @DisplayName("시도횟수 빈값 예외 테스트")
    void createCar_inputLap_blank_exception_test() {
        RacingGameService racingGameService = new RacingGameService();

        String input = "";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            racingGameService.inputLap();
        });
    }

    @Test
    @DisplayName("시도횟수 문자 예외 테스트")
    void createCar_inputLap_not_number_exception_test() {
        RacingGameService racingGameService = new RacingGameService();

        String input = "a";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingGameService.inputLap();
        });
    }

    @Test
    @DisplayName("시도횟수 20 이상 입력 예외 테스트")
    void createCar_inputLap_20_upper_exception_test() {
        RacingGameService racingGameService = new RacingGameService();

        String input = "21";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingGameService.inputLap();
        });
    }

}
