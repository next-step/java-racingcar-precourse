package com.freeefly.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarNameValidatorTest {
    private CarNameValidator validator;

    @BeforeEach
    void init() {
        validator = new CarNameValidator();
    }

    @DisplayName("입력이 없을 경우 false 를 리턴해야 한다")
    @Test
    void testEmtpyString() {
        String input = "";
        Boolean nameValid = validator.isNameValid(input);
        assertFalse(nameValid);
    }

    @DisplayName("차 이름의 길이(0 < n <= 5) 가 맞지 않을 경우 false 를 리턴해야 한다")
    @Test
    void testCarNameLength() {
        String input = "GM3,K5,Diablo";
        Boolean nameValid = validator.isNameValid(input);
        assertFalse(nameValid);
    }

}