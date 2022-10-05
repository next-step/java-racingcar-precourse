package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import static racingcar.common.Constants.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CircuitTest {

    private final Circuit circuit;
    private static final List<Car> carList = new ArrayList<>();

    CircuitTest() {
        this.circuit = new Circuit();
    }

    @BeforeAll
    static void init() {
        carList.add(Car.valueOf("Avent", 0));
        carList.add(Car.valueOf("Tusca", 0));
        carList.add(Car.valueOf("Boxst", 0));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 1})
    @DisplayName("setLapsTest:[success]")
    void setLapsTest(int input) {
        //when
        this.circuit.setLaps(Laps.from(input));
        //then
        assertThat(this.circuit.getCurrentLaps()).isEqualTo(input);
    }

    @Test
    @DisplayName("setLapsTest (중복 초기화 예외):[failure]")
    void setLaps_initializeDuplicateTest() {
        //given
        int input = 1;
        //when
        this.circuit.setLaps(Laps.from(input));
        Laps laps = Laps.from(input);
        //then
        assertThatThrownBy(() -> this.circuit.setLaps(laps))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(COMMON_ERROR_HEADER.concat(ERROR_INITIALIZE_DUPLICATE));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "12345", "1"})
    @DisplayName("setRacingCarListTest:[success]")
    void setRacingCarListTest(String input) {
        //given
        List<Car> carList = getCarListWithInputArr(getIntegerInputArr(input.split("")));
        //when
        this.circuit.setRacingCarList(RacingCarList.fromCarList(carList));
        //then
        assertThat(this.circuit.getAllStatus()).isNotEmpty();
    }

    @Test
    @DisplayName("setRacingCarListTest_initializeDuplicate:[failure]")
    void setRacingCarList_initializeDuplicateTest() {
        //when
        this.circuit.setRacingCarList(RacingCarList.fromCarList(carList));
        RacingCarList racingCarList = RacingCarList.fromCarList(carList);

        //then
        assertThatThrownBy(() -> this.circuit.setRacingCarList(racingCarList))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(COMMON_ERROR_HEADER.concat(ERROR_INITIALIZE_DUPLICATE));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "12345", "1"})
    @DisplayName("getAllStatusTest:[success]")
    void getAllStatusTest(String input) {
        //given
        List<Car> carList = getCarListWithInputArr(getIntegerInputArr(input.split("")));
        //when
        this.circuit.setRacingCarList(RacingCarList.fromCarList(carList));
        //then
        assertThat(this.circuit.getAllStatus()).isNotEmpty();
    }

    @Test
    void getCurrentLapsTest() {
        //given
        int input = 5;
        //when
        this.circuit.setLaps(Laps.from(input));
        //then
        assertThat(this.circuit.getCurrentLaps()).isEqualTo(input);
    }

    @Test
    void decreaseLapsTest() {
        //given
        int input = 5, amount = 2;
        //when
        this.circuit.setLaps(Laps.from(input));
        this.circuit.decreaseLaps(amount);
        //then
        assertThat(this.circuit.getCurrentLaps()).isEqualTo(input - amount);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    @DisplayName("raceTest:[success]")
    void raceTest(int trial) {
        //given
        String[] str2 = {"Avent : -", "Tusca : -", "Boxst : -"};
        //when
        RacingCarList racingCarList = getRacedRacingCarList(trial);
        //then
        for (int i = 0; i < 3; i++) {
            assertThat(racingCarList.getAllStatus()[i]).isEqualTo(racingCarList.getCarStatus(i));
        }
    }

    @Test
    void getWinnerListString() {
        //when
        this.circuit.setRacingCarList(getRacedRacingCarList(5));
        String listString = this.circuit.getWinnerListString();
        //then
        assertThat(listString).containsAnyOf("Avent", "Tusca", "Boxst");
    }

    private int[] getIntegerInputArr(String[] inputArr) {
        int[] resultRecord = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            resultRecord[i] = Integer.parseInt(inputArr[i]);
        }
        return resultRecord;
    }

    private List<Car> getCarListWithInputArr(int[] inputArr) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < inputArr.length; i++) {
            carList.add(Car.valueOf("car".concat(Integer.toString(i)), inputArr[i]));
        }
        return carList;
    }

    private RacingCarList getRacedRacingCarList(int trial) {
        RacingCarList racingCarList = RacingCarList.fromCarList(carList);
        for (int i = 0; i < trial; i++) {
            racingCarList.race();
        }
        return racingCarList;
    }
}