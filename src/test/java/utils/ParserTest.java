package utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {
    @Test
    @DisplayName("유효한 이름 입력 테스트")
    void validNameInput (){
        //given
        var input = "Car1, Car2, Car3";
        var expected = List.of("Car1", "Car2", "Car3");
        //when
        var output = Parser.validateCarNameInput(input);
        //then
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("공백을 포함한 이름 입력 테스트")
    void invalidNameInputWithBlank (){
        //given
        var input = "Car1, , Car3";
        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> Parser.validateCarNameInput(input));
    }

    @Test
    @DisplayName("유효한 게임 입력 테스트")
    void validGameCount (){
        //given
        var input = "1";
        var expected = 1;
        //when
        var output = Parser.validateGameCountInput(input);
        //then
        assertEquals(output, expected);
    }

    @Test
    @DisplayName("숫자가 아닌 입력값 테스트")
    void invalidGameCountWithType(){
        //given
        var input = "a";
        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> Parser.validateCarNameInput(input));
    }
}