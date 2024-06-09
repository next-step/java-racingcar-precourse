package controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EntryMoveCntTest {


    @Test
    @DisplayName("시도횟수에 문자를 입력한 경우")
    void StringInputTest() {
        assertThrows(IllegalArgumentException.class, () -> EntryMoveCnt.input("가나다"));
        String expected = "[ERROR] : 시도 횟수는 숫자가 와야합니다";
        String actual = "";
        try {
            EntryMoveCnt.input("abc");
        } catch (IllegalArgumentException e) {
            actual = e.getMessage();
        }

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1","0","-5"})
    @DisplayName("자동차 이름이 5이하가 아닌경우 테스트")
    void Under1InputTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> EntryMoveCnt.input(input));
        String expected = "[ERROR] : 시도 횟수는 숫자 1이상이여야 합니다";
        String actual = "";
        try {
            EntryMoveCnt.input(input);
        } catch (IllegalArgumentException e) {
            actual = e.getMessage();
        }

        assertEquals(expected, actual);
    }

}