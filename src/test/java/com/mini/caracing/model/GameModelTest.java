package com.mini.caracing.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameModelTest {

    private GameModel gameModel;

    @BeforeEach
    public void setUp() {
        gameModel = new GameModel();
    }


    @ParameterizedTest
    @DisplayName("게임 초기 세팅 테스트")
    @CsvSource({
        "'pobi,woni,jun', 5",
        "'car1,car2,car3', 3"
    })
    public void testInitGameModel(String carNameInput, int totalMove) {
        List<String> carNames = Arrays.asList(carNameInput.split(","));
        gameModel.initGameModel(carNames, totalMove);

        assertThat(gameModel.getCarDistances()).hasSize(carNames.size());
        assertThat(gameModel.getCarDistances().keySet()).containsExactlyElementsOf(carNames);
        assertThat(gameModel.getCarDistances().values()).containsOnly(0);
    }
}