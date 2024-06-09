package controller;

import model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DecisionWinnerTest {

    @Test
    @DisplayName("우승자 정상적으로 판별되는지 테스트1")
    void decideWinnerTest1() {
        Vector<Car> carList = new Vector<>();
        carList.add(new Car(10, "a" ));
        carList.add(new Car(5, "b"));
        carList.add(new Car(2, "c"));
        carList.add(new Car(11, "d"));

        Vector<String> expected = new Vector<>();
        expected.add("d");

        Vector<String> actual = DecisionWinner.decideWinner(carList);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("우승자 정상적으로 판별되는지 테스트2")
    void decideWinnerTest2() {
        Vector<Car> carList = new Vector<>();
        carList.add(new Car(11, "a"));
        carList.add(new Car(11, "b"));
        carList.add(new Car(11, "c"));
        carList.add(new Car(11, "d"));

        Vector<String> expected = new Vector<>();
        expected.add("a");
        expected.add("b");
        expected.add("c");
        expected.add("d");


        Vector<String> actual = DecisionWinner.decideWinner(carList);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("우승자 정상적으로 판별되는지 테스트3")
    void decideWinnerTest3() {
        Vector<Car> carList = new Vector<>();
        carList.add(new Car(11, "a"));
        carList.add(new Car(5, "b"));
        carList.add(new Car(5, "c"));
        carList.add(new Car(11, "d"));

        Vector<String> expected = new Vector<>();
        expected.add("a");
        expected.add("d");


        Vector<String> actual = DecisionWinner.decideWinner(carList);
        assertEquals(expected, actual);
    }

    //decideWinner만 테스트

}