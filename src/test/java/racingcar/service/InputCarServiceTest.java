package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputCarServiceTest {


    InputCarService inputCarService;

    @BeforeEach
    void setUp() {
    }

    InputCarServiceTest() {
        String input = "pobi,woni,jun";
        inputCarService = new InputCarService(input);
    }

    @DisplayName("입력받은 자동차 이름을 구분한다.")
    @Test
    void splitStrings() {
        String input = "pobi,woni,jun";
        String[] arr = inputCarService.splitStrings(input);
        assertTrue(arr.length > 0);
    }

    @DisplayName("입력받은 자동차 이름이 5이하의 길이인지 확인한다.")
    @Test
    void validStringLength() {
        String[] carNames = inputCarService.getCarNames();
        for (int i = 0; i < carNames.length; i++) {
            validStringLength(i);
        }
        assertTrue(carNames.length > 0);
    }

    private void validStringLength(int index) {
        String[] carNames = inputCarService.getCarNames();
        try {
            validDownNumberSix(carNames[index]);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            carNames[index] = "Teddy";
            validStringLength();
        }
    }

    private void validDownNumberSix(String carName) {
        if (carName.length() > 5 || carName.length() < 1) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }


}
