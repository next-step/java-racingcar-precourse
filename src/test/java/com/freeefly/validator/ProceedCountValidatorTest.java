package com.freeefly.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProceedCountValidatorTest {

    private ProceedCountValidator validator;

    @BeforeEach
    void init() {
        validator = new ProceedCountValidator();
    }

    @DisplayName("시도 횟수가 숫자가 아니면 false 를 반환해야 한다")
    @Test
    void testIsNumber() {
        String input = "My name";
        Boolean proceedCountValid = validator.isProceedCountValid(input);
        assertFalse(proceedCountValid);
    }

}