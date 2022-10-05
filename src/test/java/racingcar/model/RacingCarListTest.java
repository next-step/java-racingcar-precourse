package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.Constants;

class RacingCarListTest {

    private static final List<Car> carList = new ArrayList<>();

    @BeforeAll
    static void init() {
        carList.add(Car.valueOf("Avent", 0));
        carList.add(Car.valueOf("Tusca", 0));
        carList.add(Car.valueOf("Boxst", 0));
    }

    @ParameterizedTest
    @CsvSource({"Avent,Avent : -", "Tusca,Tusca : -", "Boxst, Boxst : -"})
    @DisplayName("fromCarListTest:[success]")
    void fromCarListTest(String input, String expected) {
        //given
        List<Car> insideCarList = new ArrayList<>();
        insideCarList.add(Car.valueOf(input, 1));

        //when
        RacingCarList racingCarList = RacingCarList.fromCarList(insideCarList);

        //then
        assertThat(racingCarList.getCarStatus(0)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Lamborghini Aventador", "Hyundai Tuscani", "Porsche Boxster"})
    @DisplayName("fromCarListTest (차 이름 예외):[failure]")
    void fromCarListExceptionTest_NameSizeOver(String input) {
        //given
        List<Car> carList = new ArrayList<>();
        carList.add(Car.valueOf(input, 1));
        //when & then
        assertThatThrownBy(() -> RacingCarList.fromCarList(carList)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        Constants.COMMON_ERROR_HEADER);
    }

    @Test
    @DisplayName("fromCarListTest (중복 차량 예외):[failure]")
    void fromCarListExceptionTest_CarDuplicate() {
        //given
        carList.add(Car.valueOf("Avent", 0));
        //when & then
        assertThatThrownBy(() -> RacingCarList.fromCarList(carList)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        Constants.COMMON_ERROR_HEADER);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    @DisplayName("raceTest:[success]")
    void raceTest(int trial){
        //given
        String[] str2 = {"Avent : -", "Tusca : -", "Boxst : -"};
        //when
        RacingCarList racingCarList = getRacedRacingCarList(trial);
        //then
        for (int i = 0; i <3; i++) {
            assertThat(racingCarList.getAllStatus()[i]).isEqualTo(racingCarList.getCarStatus(i));
        }
    }

    @ParameterizedTest
    @CsvSource({"123,1","111,3","122,2","221,2"})
    @DisplayName("getWinnerListTest (사이즈 테스트):[success]")
    void getWinnerList_sizeTest(String input,int expected){
        //when
        int[] inputArr = getIntegerInputArr(input.split(""));
        List<Car> carList = getCarListWithInputArr(inputArr);
        RacingCarList racingCarList = RacingCarList.fromCarList(carList);
        //then
        List<String> winnerList = racingCarList.getWinnerList();
        assertThat(winnerList).hasSize(expected);
    }

    private List<Car> getCarListWithInputArr(int[] inputArr) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < inputArr.length; i++) {
            carList.add(Car.valueOf("car".concat(Integer.toString(i)), inputArr[i]));
        }
        return carList;
    }

    private RacingCarList getRacedRacingCarList(int trial){
        RacingCarList racingCarList = RacingCarList.fromCarList(carList);
        for (int i = 0; i < trial; i++) {
            racingCarList.race();
        }
        return racingCarList;
    }

    private int[] getIntegerInputArr(String[] inputArr){
        int[] resultRecord = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            resultRecord[i] = Integer.parseInt(inputArr[i]);
        }
        return resultRecord;
    }

}