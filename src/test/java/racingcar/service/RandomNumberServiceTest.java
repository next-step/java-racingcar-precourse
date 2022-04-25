package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Joiners;
import racingcar.domain.Player;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.wrap.CarNumbers.END_NUMBER;
import static racingcar.domain.wrap.CarNumbers.START_NUMBER;

/**
 * @author : choi-ys
 * @date : 2022/04/22 12:44 오후
 */
@DisplayName("Service:RandomNumber")
public class RandomNumberServiceTest {
    private RandomNumberService randomNumberService;

    @BeforeEach
    void setUp() {
        randomNumberService = new RandomNumberService();
    }

    @Test
    @DisplayName("단일 라운드 진행을 위해, 각 Car 객체에 난수 생성")
    public void generateSingleRoundRandomNumberCarTest() {
        // Given
        String name = "마카롱택시";
        Car car = new Car(name);

        // When
        randomNumberService.generateSingleRoundRandomNumberByCar(car);

        // Then
        assertThat(car.getCarNumbers().getNumbers().get(0)).isBetween(START_NUMBER, END_NUMBER);
    }

    @Test
    @DisplayName("단일 라운드 진행을 위해, 각 Car 객체에 생성한 난수 할당")
    public void generatedSingleRoundRandomNumberTest() {
        // Given
        String namesByComma = "람보르기니,마카롱택시,카카오택시,우라칸,밀레";
        int totalRound = 5;
        Player player = Player.of(namesByComma, totalRound);
        Joiners joiners = Joiners.of(player);

        // When
        randomNumberService.generateSingleRoundRandomNumberByCars(joiners);

        // Then
        for (int i = 0; i < joiners.getCarsSize(); i++) {
            Car carByIndex = joiners.getCarByIndex(i);
            List<Integer> carNumberList = carByIndex.getCarNumbers().getNumbers();
            assertThat(carNumberList.get(0)).isBetween(START_NUMBER, END_NUMBER);
        }
    }
}