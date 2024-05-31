package controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import model.Car;

public class ServiceTest {
    @Test
    @DisplayName("is Singleton pattern working")
    void testGetInstance() {
        Service service1 = Service.getInstance();
        Service service2 = Service.getInstance();
        assertTrue(service1 == service2);
    }

    @ParameterizedTest
    @DisplayName("is generated percent list size same as car length and each percent is between 0 and 9")
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 })
    void testGeneratePercent(Integer carLength) {
        Service service = Service.getInstance();
        List<Integer> percentList = service.generatePercent(carLength);
        assertTrue(percentList.size() == carLength);
        assertTrue(percentList.stream().allMatch(percent -> percent >= 0 && percent <= 9));
    }

    // Car 클래스의 distance를 세팅할 수 없기에 별도의 메서드 작성
    static Car setDistance(Car car, Integer moveCount) {
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }
        return car;
    }

    // Car 클래스의 name과 distance를 설정한 리스트를 리턴하는 메서드
    static List<Car> getCarList(List<String> carNames, List<Integer> distances) {
        List<Car> cars = new LinkedList<>();
        for (int i = 0; i < carNames.size(); i++) {
            cars.add(setDistance(new Car(carNames.get(i)), distances.get(i)));
        }
        return cars;
    }

    static Stream<Arguments> testMovedCarAndWinner() {
        List<Arguments> arguments = new LinkedList<>();
        arguments.add(Arguments.of(getCarList(List.of("pobi", "woni", "jun"), List.of(5, 3, 5)),
                getCarList(List.of("pobi", "jun"), List.of(5, 5))));
        arguments.add(Arguments.of(getCarList(List.of("aaa", "bbb", "ccc", "ddd"), List.of(1, 2, 3, 4)),
                getCarList(List.of("ddd"), List.of(4))));
        arguments.add(Arguments.of(getCarList(List.of("lee"), List.of(1)),
                getCarList(List.of("lee"), List.of(1))));

        return arguments.stream();
    }

    @ParameterizedTest
    @DisplayName("return most distance car list")
    @MethodSource("testMovedCarAndWinner")
    void testGetWinner(List<Car> cars, List<Car> winners) {
        Service service = Service.getInstance();
        List<Car> winnerCarsFromServiceGetWinner = service.getWinner(cars);
        assertTrue(winnerCarsFromServiceGetWinner.size() >= 1);
        assertTrue(winners.size() == winnerCarsFromServiceGetWinner.size());
        for (int i = 0; i < winners.size(); i++) {
            assertTrue(winnerCarsFromServiceGetWinner.get(i).getName().equals(winners.get(i).getName()));
            assertTrue(winnerCarsFromServiceGetWinner.get(i).getDistance().equals(winners.get(i).getDistance()));
        }
    }
}
