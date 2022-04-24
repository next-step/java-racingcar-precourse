package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void CarInitTest(){
        assertThatThrownBy(() -> {

            Car FirstCar = new Car("lshy123");

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }

    @Test
    void CarMoveTest(){
        CarResult result = new CarResult();
        result.move(CarStatus.FOWARD);
        result.move(CarStatus.FOWARD);
        result.move(CarStatus.FOWARD);
        result.move(CarStatus.BACKWORD);
        assertThat(result.getLocation()).isEqualTo(2);
    }

    @Test
    void CarNotMoveTest(){
        CarResult result = new CarResult();
        result.move(CarStatus.BACKWORD);
        result.move(CarStatus.BACKWORD);
        assertThat(result.getLocation()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:poni", "1:javaj", "2:lshy"}, delimiter = ':')
    void CarTest(int index, String expect){
        Cars cars = new Cars("poni,javaj,lshy");
        assertThat(cars.getCarList().get(index).getName()).isEqualTo(expect);
    }

    @Test
    void CarResultsEndTest(){
        CarResults carResults = new CarResults(1, "1");
        assertThat(carResults.isGameEnd()).isEqualTo(false);
    }

    @Test
    void CarResultsNotEndTest(){
        CarResults carResults = new CarResults(1, "3");
        assertThat(carResults.isGameEnd()).isEqualTo(false);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1", "2:0"}, delimiter = ':')
    void CarMovePlayTest(int index, int expect){
        CarResults carResults = new CarResults(3, "3");

        List<CarStatus> moveCommandList = new ArrayList<>();
        moveCommandList.add(CarStatus.BACKWORD);
        moveCommandList.add(CarStatus.FOWARD);
        moveCommandList.add(CarStatus.BACKWORD);
        carResults.playMove(moveCommandList);
        assertThat(carResults.getCarResults().get(index).getLocation()).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:2", "1:3", "2:0"}, delimiter = ':')
    void CarMovePlay3TimeTest(int index, int expect){
        CarResults carResults = new CarResults(3, "3");

        List<CarStatus> moveCommandList = new ArrayList<>();
        moveCommandList.add(CarStatus.BACKWORD);
        moveCommandList.add(CarStatus.FOWARD);
        moveCommandList.add(CarStatus.BACKWORD);
        carResults.playMove(moveCommandList);

        moveCommandList = new ArrayList<>();
        moveCommandList.add(CarStatus.FOWARD);
        moveCommandList.add(CarStatus.FOWARD);
        moveCommandList.add(CarStatus.BACKWORD);
        carResults.playMove(moveCommandList);

        moveCommandList = new ArrayList<>();
        moveCommandList.add(CarStatus.FOWARD);
        moveCommandList.add(CarStatus.FOWARD);
        moveCommandList.add(CarStatus.BACKWORD);
        carResults.playMove(moveCommandList);

        assertThat(carResults.getCarResults().get(index).getLocation()).isEqualTo(expect);
    }

}
