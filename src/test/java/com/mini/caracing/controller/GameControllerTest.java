package com.mini.caracing.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import com.mini.caracing.controller.validator.Validator;
import com.mini.caracing.model.GameModel;
import com.mini.caracing.view.GameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameControllerTest {

    private GameModel gameModel = new GameModel();
    private GameView gameView = new GameView();

    @BeforeEach
    public void setUp() {
        GameController gameController = new GameController(gameModel, gameView);
    }

    @ParameterizedTest
    @DisplayName("차랑 이름 입력값 유효성 검사")
    @CsvSource({
        "'', 'is blank'",
        "'car1, car2', 'contains blank'",
        "',', 'no car name'",
        "'abcdef,ghk', 'longer'",
        "'car1,car1', 'duplicated'"
    })
    void testValidateCarNames(String carNamesInput, String errorMessage) {
        assertThatThrownBy(() -> Validator.validateCarNames(carNamesInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(errorMessage);
    }

    @ParameterizedTest
    @DisplayName("이동 횟수 입력값 유효성 검사")
    @CsvSource({
        "'', 'is not integer number'",
        "'3.14', 'is not integer number'",
        "'number', 'is not integer number'",
        "'0', 'below zero'",
        "'-3', 'below zero'"
    })
    void testValidateTotalMove(String totalMoveInput, String errorMessage) {
        assertThatThrownBy(() -> Validator.validateTotalMove(totalMoveInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(errorMessage);
    }
}