package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TrackTest {

    @Test
    @DisplayName("generateCarTest")
    void generateCarTest (){
        //given
        var track = new Track();
        var carNames = List.of("Car1", "Car2", "Car3");
        //when
        for (String carName : carNames) {
            track.addCar(carName);
        }
        var savedCar = track.getCars();
        //then
        assertEquals(carNames, savedCar.stream().map(Car::getName).toList());
    }
    
    @Test
    @DisplayName("step 진행 테스트")
    void stepTest (){
        //given
        var track = new Track();
        var carNames = List.of("Car1", "Car2", "Car3");
        var seeds = List.of(2,3,4);
        for (String carName : carNames) {
            track.addCar(carName);
        }
        //when
        track.step(seeds);
        //then
        var position = List.of(0,0,1);
        assertEquals(position, track.getCars().stream().map(Car::getPosition).toList());
    }

    @Test
    @DisplayName("우승자 반환 테스트")
    void winnerTest (){
        //given
        var track = new Track();
        var carNames = List.of("Car1", "Car2", "Car3");
        var seeds = List.of(2,3,4);
        for (String carName : carNames) {
            track.addCar(carName);
        }
        //when
        track.step(seeds);
        //then
        var answer = List.of("Car3");
        assertEquals(answer, track.getWinners().stream().map(Car::getName).toList());
    }

    @Test
    @DisplayName("다중우승자 반환 테스트")
    void multipleWinnerTest (){
        //given
        var track = new Track();
        var carNames = List.of("Car1", "Car2", "Car3");
        var seeds = List.of(2,5,4);
        for (String carName : carNames) {
            track.addCar(carName);
        }
        //when
        track.step(seeds);
        //then
        var answer = List.of("Car2", "Car3");
        assertEquals(answer, track.getWinners().stream().map(Car::getName).toList());
    }
}