package com.freeefly.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class RacingCarListTest {

    @DisplayName("전체 승자에 대한 텍스트를 리턴할 경우 승자에 대해서 쉼표로 구분된 스트링이어야 한다")
    @Test
    void testGetWinnerNames() {
        RacingCarList list = new RacingCarList();
        list.addCar("A");
        list.addCar("B");
        list.addCar("C");
        list.getCars().get(0).setWinner(true);
        list.getCars().get(2).setWinner(true);
        List<String> winnerNames = list.getWinnerNames();
        List<String> expected = new ArrayList<>();
        expected.add("A");
        expected.add("C");
        assertIterableEquals(expected, winnerNames);
    }

    @DisplayName("자동차 중 가장 멀리 간 자동차가 승자가 되야 한다")
    @Test
    void testWinnerValidation() {
        RacingCarList list = new RacingCarList();
        list.addCar("A");
        list.addCar("B");
        list.addCar("C");
        list.getCars().get(0).proceed(true);
        list.getCars().get(0).proceed(true);
        list.getCars().get(0).proceed(true);
        list.getCars().get(1).proceed(true);
        list.validateWinners();
        List<String> expected = new ArrayList<>();
        expected.add("A");
        assertEquals(expected, list.getWinnerNames());
    }

}