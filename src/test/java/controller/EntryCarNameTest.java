package controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class EntryCarNameTest {

    @ParameterizedTest
    @ValueSource (strings = {"hahahahaha,hihihihihi,goooood", "bmwaudibenz,kiahyundai", "hihihihi,good,happy", ",,hi,"})
    @DisplayName("자동차 이름이 1이상 5이하가 아닌경우 테스트")
    void invalidInputTest(String input) {
        assertThrows(IllegalArgumentException.class,()->EntryCarName.input(input));
        String expected = "[ERROR] : 자동차 이름의 길이는 1이상 5이하여야 합니다";
        String actual="";
        try{
           EntryCarName.input(input);
        } catch (IllegalArgumentException e) {
            actual = e.getMessage();
        }

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("자동차 이름을 입력하지 않은 경우")
    void blankInputTest() {
        assertThrows(IllegalArgumentException.class, () -> EntryCarName.input(""));
        String expected = "[ERROR] : 자동차 이름을 입력하지 않았습니다. 다시 입력해주세요";
        String actual = "";
        try {
            EntryCarName.input("");
        } catch (IllegalArgumentException e) {
            actual = e.getMessage();
        }

        assertEquals(expected, actual);
    }



    @Test
    @DisplayName("올바른 값이 입력되었을때의 테스트")
    void validInputTest() {
        Vector<String> expected = new Vector<>();
        expected.add("Audi");
        expected.add("Benz");
        expected.add("Bmw");

        Vector<String> actual = EntryCarName.input("Audi,Benz,Bmw");
        assertEquals(expected, actual);
    }
}