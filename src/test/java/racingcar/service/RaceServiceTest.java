package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.Joiners;
import racingcar.domain.Player;
import racingcar.domain.response.CarRaceResult;
import racingcar.domain.response.PlayResult;
import racingcar.domain.response.RoundResult;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * @author : choi-ys
 * @date : 2022/04/23 4:53 오후
 */
@DisplayName("Service:Race")
class RaceServiceTest {
    private final String name = "마카롱택시";
    int currentRound = 1;
    private Car car;

    private String namesByComma = "람보르기니,마카롱택시,카카오택시,우라칸,밀레";
    private int totalRound = 5;
    private Player player;
    private Joiners joiners;

    private RaceService raceService;

    @BeforeEach
    void setUp() {
        car = new Car(name);
        player = Player.of(namesByComma, totalRound);
        joiners = Joiners.of(player);

        raceService = new RaceService(new RandomNumberService());
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("단일 차량의 단일 라운드 진행 Test : 전진")
    public void playSingleRound_andAssertionsGoTest(int randomNumber) {
        // Given
        car.addNumber(randomNumber);

        // When
        CarRaceResult carRaceResult = raceService.playSingleRoundByCar(car, currentRound);

        // Then
        assertThat(carRaceResult.getCar()).isEqualTo(car);
        assertThat(carRaceResult.getRoundStatus().isGo()).isTrue();
    }

    private static Stream playSingleRound_andAssertionsGoTest() {
        return Stream.of(
                Arguments.of(4),
                Arguments.of(9)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("단일 차량의 단일 라운드 진행 Test : 멈춤")
    public void playSingleRound_andAssertionsStopTest(int randomNumber) {
        // Given
        car.addNumber(randomNumber);

        // When
        CarRaceResult carRaceResult = raceService.playSingleRoundByCar(car, currentRound);

        // Then
        assertThat(carRaceResult.getCar()).isEqualTo(car);
        assertThat(carRaceResult.getRoundStatus().isStop()).isTrue();
    }

    private static Stream playSingleRound_andAssertionsStopTest() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(3)
        );
    }

    @Test
    @DisplayName("전체 차량의 단일 라운드 진행 Test")
    public void playSingleRoundByCars_andAssertionsResultTest() {
        // Given
        joiners.getCarByIndex(0).addNumber(1);
        joiners.getCarByIndex(1).addNumber(2);
        joiners.getCarByIndex(2).addNumber(3);
        joiners.getCarByIndex(3).addNumber(4);
        joiners.getCarByIndex(4).addNumber(5);

        // When
        RoundResult roundResult = raceService.playSingleRoundByCars(joiners, 1);

        // Then
        List<CarRaceResult> raceResults = roundResult.getRaceResults();
        assertAll(
                () -> assertThat(roundResult.getCurrentRound()).isEqualTo(1),
                () -> assertThat(raceResults.get(0).getRoundStatus().isStop()).isTrue(),
                () -> assertThat(raceResults.get(1).getRoundStatus().isStop()).isTrue(),
                () -> assertThat(raceResults.get(2).getRoundStatus().isStop()).isTrue(),
                () -> assertThat(raceResults.get(3).getRoundStatus().isGo()).isTrue(),
                () -> assertThat(raceResults.get(4).getRoundStatus().isGo()).isTrue()
        );
    }

    @Test
    @DisplayName("전체 차량의 전체 라운드 진행 Test : 단일 우승")
    public void playAllRoundByCars_andAssertionsSingleWinnerTest() {
        // Given
        addNumbersByCar_singleWinner();

        // When
        PlayResult playResult = raceService.play(joiners, player);

        // Then
        assertAll(
                () -> assertThat(joiners.getCarByIndex(0).getScore()).as("첫번째 차량의 전진 횟수").isEqualTo(2),
                () -> assertThat(joiners.getCarByIndex(1).getScore()).as("두번째 차량의 전진 횟수").isEqualTo(4),
                () -> assertThat(joiners.getCarByIndex(2).getScore()).as("세번째 차량의 전진 횟수").isEqualTo(1),
                () -> assertThat(joiners.getCarByIndex(3).getScore()).as("네번째 차량의 전진 횟수").isEqualTo(5),
                () -> assertThat(joiners.getCarByIndex(4).getScore()).as("다섯번째 차량의 전진 횟수").isEqualTo(3),
                () -> assertThat(playResult.getWinners().getWinnerNames()).isEqualTo(joiners.getCarByIndex(3).getCarName())
        );
    }

    @Test
    @DisplayName("전체 차량의 전체 라운드 진행 Test : 공동 우승")
    public void playAllRoundByCars_andAssertionsJointWinnerTest() {
        // Given
        addNumbersByCar_jointWinner();

        // When
        PlayResult playResult = raceService.play(joiners, player);

        // Then
        assertAll(
                () -> assertThat(joiners.getCarByIndex(0).getScore()).as("첫번째 차량의 전진 횟수").isEqualTo(2),
                () -> assertThat(joiners.getCarByIndex(1).getScore()).as("두번째 차량의 전진 횟수").isEqualTo(4),
                () -> assertThat(joiners.getCarByIndex(2).getScore()).as("세번째 차량의 전진 횟수").isEqualTo(1),
                () -> assertThat(joiners.getCarByIndex(3).getScore()).as("네번째 차량의 전진 횟수").isEqualTo(4),
                () -> assertThat(joiners.getCarByIndex(4).getScore()).as("다섯번째 차량의 전진 횟수").isEqualTo(3),
                () -> assertThat(playResult.getWinners().getWinnerNames()).isEqualTo(joiners.getCarByIndex(1).getCarName() + ", " + joiners.getCarByIndex(3).getCarName())
        );
    }

    private void addNumbersByCar_singleWinner() {
        int[] firstCarRandomNumbers = {1, 2, 3, 4, 5};
        int[] secondCarRandomNumbers = {1, 9, 6, 4, 5};
        int[] thirdCarRandomNumbers = {1, 2, 1, 1, 5};
        int[] forthCarRandomNumbers = {5, 4, 6, 7, 9};
        int[] fifthCarRandomNumbers = {8, 2, 4, 2, 5};

        addNumbers(joiners.getCarByIndex(0), firstCarRandomNumbers);
        addNumbers(joiners.getCarByIndex(1), secondCarRandomNumbers);
        addNumbers(joiners.getCarByIndex(2), thirdCarRandomNumbers);
        addNumbers(joiners.getCarByIndex(3), forthCarRandomNumbers);
        addNumbers(joiners.getCarByIndex(4), fifthCarRandomNumbers);
    }

    private void addNumbersByCar_jointWinner() {
        int[] firstCarRandomNumbers = {1, 2, 3, 4, 5};
        int[] secondCarRandomNumbers = {1, 9, 6, 4, 5};
        int[] thirdCarRandomNumbers = {1, 2, 1, 1, 5};
        int[] forthCarRandomNumbers = {5, 4, 6, 7, 1};
        int[] fifthCarRandomNumbers = {8, 2, 4, 2, 5};

        addNumbers(joiners.getCarByIndex(0), firstCarRandomNumbers);
        addNumbers(joiners.getCarByIndex(1), secondCarRandomNumbers);
        addNumbers(joiners.getCarByIndex(2), thirdCarRandomNumbers);
        addNumbers(joiners.getCarByIndex(3), forthCarRandomNumbers);
        addNumbers(joiners.getCarByIndex(4), fifthCarRandomNumbers);
    }

    private void addNumbers(Car car, int[] randomNumbers) {
        for (int randomNumber : randomNumbers) {
            car.addNumber(randomNumber);
        }
    }
}